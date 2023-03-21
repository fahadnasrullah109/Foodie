package com.foodie.presentation.profile

import com.foodie.R

sealed class PaymentItem(val icon: Int, val title: Int) {
    object Card : PaymentItem(R.drawable.ic_payment_card, R.string.card_label)
    object Bank : PaymentItem(R.drawable.ic_payment_bank, R.string.bank_label)
    object Paypal : PaymentItem(R.drawable.ic_payment_paypal, R.string.paypal_label)
}
