package com.example.iyeongjun.gucknaesan.ex

import android.media.tv.TvContract.Programs.Genres.SHOPPING
import android.util.Log
import com.example.iyeongjun.gucknaesan.util.*

fun String.getLimitedString(length: Int): String {
    var result = ""
    val arr = this.split("")
    var count = 0
    for (node in arr) {
        if (this.length < length) {
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
fun String.getTourToDate() : String {

    val temp = this.substring(0,8)
    val year = temp.substring(0,4)
    val month = temp.substring(4,6)
    val day = temp.substring(6,8)

    for (i in temp) Log.d(this,i.toString())

    return "$year - $month - $day"
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
        "제주도" -> result = "제주특별자치도"
        else -> result = this
    }
    Log.d("temp", "$this /")
    return result

}
fun String.convertType(): String {
    val TOUR = 12
    val COULTURE = 14
    val CANIVAL = 15
    val REPORTS = 28
    val INN = 32
    val SHOPPING = 38
    val FOOD = 39
    val COURSE = 25
    val ALL = 10000
/*타국가*/
    val OTOUR = 76
    val OCOULTURE = 78
    val OCANIVAL = 85
    val OREPORTS = 75
    val OINN = 80
    val OSHOPPING = 79
    val OFOOD = 82
    val OTANS = 7

    var result = ""
    val type = Integer.parseInt(this)
    if (type == TOUR || type == OTOUR)
        result = "관광"
    else if (type == COULTURE || type == OCOULTURE)
        result = "문화시설"
    else if (type == CANIVAL || type == OCANIVAL)
        result = "행사/공연/축제"
    else if (type == REPORTS || type == OREPORTS)
        result = "레포츠"
    else if (type == INN || type == OINN)
        result = "숙박"
    else if (type == SHOPPING || type == OSHOPPING)
        result = "쇼핑"
    else if (type == FOOD || type == OFOOD)
        result = "음식점"
    else if (type == COURSE || type == OTANS)
        result = "여행코스"
    else if (type == ALL)
        result = "문화"
    else
        result = "기타"
    return result
}
