package com.example.taxcalculator

class TaxComputation(val num: Double){

    private var SSS = getSSS(num)
    private var Philhealth = getPhilhealth(num)
    private var pagIbig = getPagIbig(num)
    private var totalContri = pagIbig + Philhealth + SSS

    private var incomeTax = getIncomeTax(num, totalContri)
    private var totalDeduc = totalContri + incomeTax
    private var netPayAfterDeduc = num - totalDeduc
    private var netPayAfterTax = num - incomeTax


    fun getSSS(): Double{
        return SSS
    }

    fun getPhilhealth(): Double{
        return Philhealth
    }

    fun getPagIbig(): Double{
        return pagIbig
    }

    fun getTotalContri(): Double{
        return totalContri
    }

    fun getIncomeTax(): Double{
        return incomeTax
    }

    fun getTotalDeduc(): Double{
        return totalDeduc
    }

    fun getNetPayDeduc(): Double{
        return netPayAfterDeduc
    }

    fun getNetPayTax(): Double{
        return netPayAfterTax
    }

}

fun getPhilhealth(income: Double): Double {

    val philContri: Double
    if(income <= 10000)
        philContri = 225.0
    else if(income < 90000)
        philContri = income * 0.0225
    else
        philContri = 4050.00
    return philContri
}

fun getPagIbig(income: Double): Double {
    return if(income <=1500)
        income * 0.01
    else if (income <= 4999.8)
        income * 0.02
    else
        100.0
}

fun getSSS(income: Double): Double{

    var result: Double = 0.0

    if(income < 4250){
        result = 180.0
    }
    else if (income >= 29750.00){
        result = 1350.00
    }
    else{
         result = income - 4250
         if(result > 500){
             var num = (result /500).toInt()
             num++
             result = num * 22.50 + 180
         }else{
             result + 22.50 + 180
         }
    }
    return result
}

fun getIncomeTax(income: Double, totalContri: Double): Double{

    val income = income - totalContri
    return if(income < 20833.00)
        0.00
    else if (income < 33333.00)
        (income - 20833.00) * 0.15
    else if (income < 66667)
        ((income - 33333.00) * 0.20) + 1875
    else if (income < 166667)
        ((income - 66667.00) * 0.25) + 8541.80
    else if (income < 666667)
        ((income - 166667.00) * 0.30) + 33541.80
    else ((income - 666667.00) * 0.35) + 183541.80
}