package com.example.iyeongjun.gucknaesan.ex

fun String.getLimitedString( length: Int): String {
    var result = ""
    val arr = this.split("")
    var count = 0
    for (node in arr) {
        if (count < length) {
            if (node == " ")
                count += 1
            else
                count += 2
            result += node
        }
    }
    result += ".."
    return result
}

fun String.getProvince() : String{
    var result = ""
    when(this){
        "서울" -> result = "서울특별시"
        "인천" -> result = "인천광역시"
        "울산" -> result = "울산광역시"
        "대구" -> result = "대구광역시"
        "대전" -> result = "대전광역시"
        "광주" -> result = "광주광역시"
        "부산" -> result = "부산광역시"
        "경기" -> result = "경기도"
        "제주" -> result = "제주특별자치도"
        else -> result = this
    }
    return result
}
