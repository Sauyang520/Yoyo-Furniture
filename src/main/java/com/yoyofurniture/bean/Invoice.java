package com.yoyofurniture.bean;

import com.codingerror.model.AddressDetails;
import com.codingerror.model.HeaderDetails;
import com.codingerror.model.Product;
import com.codingerror.model.ProductTableHeader;
import com.codingerror.service.CodingErrorPdfInvoiceCreator;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public record Invoice(SaleOrder saleOrder) {

    /**
     * Generate Invoice in PDF format
     * @param salesperson salesperson in charged
     * @param customer customer of this sale order
     * @throws FileNotFoundException exception
     */
    public void generateInvoice(Salesperson salesperson, Customer customer) throws FileNotFoundException {
        LocalDate ld = LocalDate.now();
        String pdfName = "src/main/resources/com.yoyofurniture.invoice/" + this.saleOrder().getSaleID() + "_" + ld + ".pdf";
        CodingErrorPdfInvoiceCreator cepdf = new CodingErrorPdfInvoiceCreator(pdfName);
        cepdf.createDocument();


        //Create Header start
        HeaderDetails header = new HeaderDetails();
        header.setInvoiceNo(this.saleOrder().getSaleID()).setInvoiceNoText("Order ID").
                setInvoiceDate(this.saleOrder().getSaleDateTime()).setInvoiceDateText("Order Data Time").build();
        cepdf.createHeader(header);
        //Header End

        //Create Address start
        AddressDetails addressDetails = new AddressDetails();
        addressDetails
                .setBillingCompany("Yoyo Furniture")
                .setBillingName(salesperson.getName())
                .setBillingAddress("""
                        AP Yoyo Factory (APYF) Jalan Teknologi 5,\s
                        Technology Park Malaysia, Bukit Jalil,\s
                        Kuala Lumpur 57000, Malaysia.""")
                .setBillingEmail("yoyocheckfurnitureout@gmail.com")
                .setShippingName(customer.getName() + "\n")
                .setShippingAddress(customer.getAddress())
                .build();

        cepdf.createAddress(addressDetails);
        //Address end

        //Product Start
        ProductTableHeader productTableHeader = new ProductTableHeader();
        cepdf.createTableHeader(productTableHeader);
        List<Product> productList = new ArrayList<>();
        for (SelectedProduct selectedProduct : this.saleOrder().getProductList()) {
            productList.add(new Product(selectedProduct.getProduct().getItemName(), selectedProduct.getQuantity(),
                    (float) selectedProduct.getAmount()));
        }
        productList = cepdf.modifyProductList(productList);
        cepdf.createProduct(productList);
        //Product End

        //Term and Condition Start
        List<String> TncList = new ArrayList<>();
        TncList.add("1. The Seller shall not be liable to the Buyer directly or indirectly for any loss or damage suffered by the Buyer.");
        TncList.add("2. The Seller warrants the product for one (1) year from the date of shipment");
        String imagePath = "src/main/resources/com.yoyofurniture.image/yoyofurniture-logo.png";
        cepdf.createTnc(TncList, true, imagePath);
        // Term and condition end\
    }
}
