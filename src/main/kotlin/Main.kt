package ru.cifrium
fun main () {
    val amount: Int = 300_000_00
    var paymentSystem = "VkPay"
    var totalCommission = paymentCommissinon(amount,paymentSystem)

    println ("Ваша коммиссия $totalCommission")
}

fun paymentCommissinon(amount: Int, paymentSystem: String): Double {
    var totalCommission = 0.0
    when(paymentSystem){
        "Visa","Мир" ->  totalCommission = visaCommission(amount)
        "Maestro", "Mastercard" -> totalCommission = masterCommission(amount)
        "VkPay" -> totalCommission = 0.0
    }
    return totalCommission
}

fun visaCommission(amount: Int): Double {
    var commission = 0.0075
    var commStart = 35_00
    var totalCommission = amount * commission
    if (totalCommission <= 3_500) {
        totalCommission = commStart.toDouble()
    }
    return totalCommission
}
fun masterCommission (amount: Int): Double {
    var commission = 0.006
    var totalCommission = amount * commission + 20_00
    if (amount <= 75_000_00){
        totalCommission = 0.0
    }
    return totalCommission
}