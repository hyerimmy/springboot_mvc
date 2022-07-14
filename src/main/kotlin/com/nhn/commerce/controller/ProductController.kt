package com.nhn.commerce.controller

import com.nhn.commerce.model.Product
import com.nhn.commerce.service.ProductService
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@Controller
class ProductController(
    private val productService: ProductService,
) {
    @GetMapping("/product")
    fun getProductList(model: Model): String {
        model.addAttribute("productList", productService.findProductList()) // DB에서 받아서 productList로 받겠다,,
        return "product" // product.html 반환
    }


    // TODO (상품 상세 조회 기능 + Exception 처리)
    @GetMapping("/product/view/{productNo}")
    fun getProductView(model: Model, @PathVariable("productNo") productNo:Int): String {
        model.addAttribute("product", productService.findProduct(productNo))
        return "view" // product.html 반환
    }


    // TODO (상품 추가 기능)
    @GetMapping("/product/add")
    fun addProduct():String {
        return "add"
    }
    @PostMapping("/product/addPro")
    fun addProductPro(productName: String , salePrice:Int):String{
        productService.addProductPro(productName= "상품명",salePrice = 0,LocalDateTime.now()) // 널일 경우 초기값 설정!!!!!
        println("productName : "+productName)
        println("salePrice : "+salePrice)
        return "redirect:/product"
    }

    // TODO (상품 수정 기능 + Exception 처리)
    @GetMapping("/product/update/{productNo}")
    fun updateProduct(model: Model, @PathVariable("productNo") productNo:Int):String{
        model.addAttribute("product", productService.findProduct(productNo))
        return "update"
    }
    @PostMapping("/product/updatePro")
    fun updateProductPro(productName: String, salePrice:Int, productNo:Int):String{
        productService.updateProductPro(productName,salePrice,LocalDateTime.now(), productNo)
        println("productName : "+productName)
        println("salePrice : "+salePrice)
        return "redirect:/product"
    }


    // TODO (상품 삭제 기능 + Exception 처리)
    @GetMapping("/product/delete")
    fun deleteProduct(productNo:Int):String{
        productService.deleteProduct(productNo)
        return "redirect:/product"
    }

}
