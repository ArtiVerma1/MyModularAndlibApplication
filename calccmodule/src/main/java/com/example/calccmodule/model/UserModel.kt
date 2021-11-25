package com.example.calccmodule.model

data class UserModel (

    @field:SerializedName("per_page")
    val perPage: Int? = null,

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("data")
    val data: List<DataItem?>? = null,

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

//	//@Embedded(prefix = "support")
//	@Ignore
    @field:SerializedName("support")
    val support: Support?=null
)

data class DataItem(


    //  @ColumnInfo(name = "id")
    @field:SerializedName("id")
    val id: Int? = null,

    // @ColumnInfo(name = "last_name")
    @field:SerializedName("last_name")
    val lastName: String? = null,

    //ColumnInfo(name = "avatar")
    @field:SerializedName("avatar")
    val avatar: String? = null,
    //@ColumnInfo(name = "first_name")
    @field:SerializedName("first_name")
    val firstName: String? = null,
    //  @ColumnInfo(name = "email")
    @field:SerializedName("email")
    val email: String? = null
)

data class Support(
    // @ColumnInfo(name = "text")
    @field:SerializedName("text")
    val text: String? = null,
    // @ColumnInfo(name = "url")
    @field:SerializedName("url")
    val url: String? = null
)
