package com.springbootprojectdress.Basics.controller;

import com.springbootprojectdress.Basics.entity.ProductDetails;
import com.springbootprojectdress.Basics.entity.Products;
import com.springbootprojectdress.Basics.serviceInterface.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/Basics-Products")
public class ProductsController {

    @Autowired
    ProductInterface productInterface;

//  create-product
    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Products products){
        String productCreateResponse = productInterface.addSingleProduct(products);

        if (productCreateResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productCreateResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ErrorOccurred");
        }
    }

//  allProduct-get
    @GetMapping("/allProduct")
    public ResponseEntity<?> allProduct(){
        List<Products> productRetrieveResponse = productInterface.getAllProduct();

        if (productRetrieveResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productRetrieveResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ErrorOccurred");
        }
    }

//  singleProduct-get
    @GetMapping("/singleProduct/{id}")
    public ResponseEntity<?> addSingleProduct(@PathVariable Long id){
        Products singleProductRetrieveResponse = productInterface.getSingleProduct(id);

        if (singleProductRetrieveResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(singleProductRetrieveResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ErrorOccurred");
        }
    }

//  update-product
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Products products, @PathVariable Long id){
        Products productUpdateResponse = productInterface.updateSingleProduct(products, id);

        if (productUpdateResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productUpdateResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ErrorOccurred");
        }
    }

//  delete-product
    @DeleteMapping("/singleProduct/{id}")
    public ResponseEntity<?> singleProduct(@PathVariable Long id){
        String productDeleteResponse = productInterface.deleteSingleProduct(id);

        if (productDeleteResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productDeleteResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ErrorOccurred");
        }
    }

//  searchCategoryWise
    @GetMapping("/searchByName/{name}")
    public ResponseEntity<?> nameProduct(@PathVariable String name){
        List<Products> productCategoryResponse = productInterface.searchProductByName(name);

        if (productCategoryResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productCategoryResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ErrorOccurred");
        }
    }


//  getCategoryWise
    @GetMapping("/category/{name}")
    public ResponseEntity<?> searchProduct(@PathVariable String name){
        List<Products> productSearchResponse = productInterface.getProductByCategory(name);

        if (productSearchResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productSearchResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ErrorOccurred");
        }
    }

    //getProductsBy -> api, productService, ratingRepo, service to repo send id
    @GetMapping("/getProductByRating/{filterRating}")
    public ResponseEntity<?> getProductByRating(@PathVariable int filterRating){
        List<Products> productByRating = productInterface.getProductByRating(filterRating);

        if (productByRating != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productByRating);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ErrorOccurred");
        }
    }

//  colorCategory
    @GetMapping("/getColorByProduct/{productColor}")
    public ResponseEntity<?> getColorByProduct(@PathVariable String productColor){
        List<Products> productByColor = productInterface.getColorByProduct(productColor);

        if (productByColor != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productByColor);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ErrorOccurred");
        }
    }


//  productPriceUpToDown
    @GetMapping("/getProductHighToLowPrice")
    public ResponseEntity<?> getProductHighToLowPrice(){
        List<Products> productHighToLowPrice = productInterface.getProductHighToLowPrice();

        if (productHighToLowPrice != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productHighToLowPrice);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ErrorOccurred");
        }
    }

//  productPriceDownToUp
    @GetMapping("/getProductLowToHighPrice")
    public ResponseEntity<?> getProductLowToHighPrice(){
        List<Products> productLowToHighPrice = productInterface.getProductLowToHighPrice();

        if (productLowToHighPrice != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productLowToHighPrice);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ErrorOccurred");
        }
    }

//  productRange
    @GetMapping("/getProductRange/{startPrice}/{endPrice}")
    public ResponseEntity<?> getProductRange(@PathVariable int startPrice, @PathVariable int endPrice){
        List<Products> productRange = productInterface.getProductRange(startPrice, endPrice);

        if (productRange != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productRange);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ErrorOccurred");
        }
    }

//  discountProducts
    @GetMapping("/getDiscountProduct")
    public ResponseEntity<?> getDiscountProduct() {
        List<Products> discountProduct = productInterface.getDiscountProduct();

        if (discountProduct != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(discountProduct);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ErrorOccurred");
        }
    }

//  productDetailPage - idByProduct
    @GetMapping("/getProductDetail/{pId}")
    public ResponseEntity<?> getProductDetail(@PathVariable Long pId) {
        ProductDetails productDetail = productInterface.getProductDetail(pId);

        if (productDetail != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productDetail);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ErrorOccurred");
        }
    }

//  uploadImage
    @PostMapping("/uploadImage")
    public  ResponseEntity<?> uploadImage (@RequestParam("file")MultipartFile images) throws IOException {
        byte[] bytes = images.getBytes();
        String uploadImage = images.getOriginalFilename();
        String fileLocation = "C:\\Users\\Dinesh-PC\\IdeaProjects\\FullStackProject\\BasicsProject\\Basics\\src\\main\\resources\\uploads\\ + uploadImage";
        Path path = Paths.get(fileLocation);
        Files.write(path,bytes);
        
        return ResponseEntity.status(HttpStatus.OK)
            .body("ErrorOccurred");

    }
}
