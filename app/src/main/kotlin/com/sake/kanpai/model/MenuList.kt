package com.sake.kanpai.model

class MenuListResponse(
        var type: String?,
        var data: DataResponse?
)

class DataResponse(
        var menu: List<MenuResponse>
)

class MenuResponse(
        var id: Int?,
        var name: String?,
        var price: Int?,
        var pict: String?
)
