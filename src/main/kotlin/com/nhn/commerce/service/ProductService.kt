package com.nhn.commerce.service

import com.nhn.commerce.model.Product
import com.nhn.commerce.repository.ProductRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ProductService(
    private val productRepository: ProductRepository,
) {

    // <--- cake.zip temp
    fun findCartList(): List<Product> = productRepository.findCartList()
    // cake.zip temp --->

    fun findProductList(): List<Product> = productRepository.findProductList()


    // TODO (상품 상세 조회 기능 + Exception 처리)
    fun findProduct(productNo:Int): Product = productRepository.findProduct(productNo)


    // TODO (상품 추가 기능)
    fun addProductPro(productName: String, salePrice:Int, registerView: LocalDateTime)
            = productRepository.addProductPro(productName,salePrice,registerView)

    // TODO (상품 수정 기능 + Exception 처리)
    fun updateProductPro(productName: String, salePrice:Int, registerView: LocalDateTime, productNo:Int)
            = productRepository.updateProductPro(productName,salePrice,registerView, productNo)

    // TODO (상품 삭제 기능 + Exception 처리)
    fun deleteProduct(productNo:Int) = productRepository.deleteProduct(productNo)
}
