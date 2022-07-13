package com.nhn.commerce.repository

import com.nhn.commerce.model.Product
import org.apache.ibatis.annotations.*
import java.time.LocalDateTime

@Mapper
interface ProductRepository {
    @Select("SELECT * FROM product")
    fun findProductList(): List<Product>


    // TODO (상품 상세 조회 기능 + Exception 처리)
    @Select("SELECT * FROM product WHERE productNo=#{productNo}")
    fun findProduct(productNo:Int): Product

    // TODO (상품 추가 기능)
    @Insert("INSERT INTO product(productName, salePrice, registerYmdt, updateYmdt) " +
            "VALUES (#{productName},#{salePrice}, #{registerView}, #{registerView})")
    fun addProductPro(productName: String, salePrice:Int, registerView: LocalDateTime)

    // TODO (상품 수정 기능 + Exception 처리)
    @Update("UPDATE product SET productName=#{productName}, salePrice=#{salePrice}, updateYmdt=#{registerView} WHERE productNo=#{productNo}")
    fun updateProductPro( productName: String, salePrice:Int, registerView: LocalDateTime, productNo:Int)
//    @Update("UPDATE product SET (productName, salePrice, updateYmdt) " +
//            "VALUES (#{productName},#{salePrice}, #{registerView})")
//    fun updateProduct(productName: String, salePrice:Int, registerView: LocalDateTime)

    // TODO (상품 삭제 기능 + Exception 처리)
    @Delete("DELETE FROM product WHERE productNo=#{productNo}")
    fun deleteProduct(productNo:Int)
}
