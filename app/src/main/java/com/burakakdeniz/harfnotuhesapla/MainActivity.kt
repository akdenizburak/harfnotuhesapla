package com.burakakdeniz.harfnotuhesapla

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

        val animDrawable = root_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(3000)
        animDrawable.start()
    }
    @SuppressLint("SetTextI18n")
    fun hesapla(view: View) {
        try {

            var v=vize.text.toString().toDouble()
            var f=finall.text.toString().toDouble()
            var s=sapma.text.toString().toDouble()
            var sort=sinifort.text.toString().toDouble()
            while(sort<35.0){
                sort=35.0
            }
            var ort=(v*4.0/10.0+f*6.0/10.0)
            var m=0.4*(60.00-sort)
            var not=""
            var harf=""
            var list=ArrayList<String>()
            var gerekennotaa=(880.0-4.0*v)/6.0
            var gerekennotba=(810.0-4.0*v)/6.0
            var gerekennotbb=(740.0-4.0*v)/6.0
            var gerekennotcb=(670.0-4.0*v)/6.0
            var gerekennotcc=(600.0-4.0*v)/6.0
            var gerekennotdc=(530.0-4.0*v)/6.0
            var gerekennotdd=(460.0-4.0*v)/6.0
            var gerekennotfd=(390.0-4.0*v)/6.0
            var gerekenbilgi="\n" +
                    "AA için Finalden ${gerekennotaa.toInt()} \n" +
                    "BA için Finalden ${gerekennotba.toInt()}\n" +
                    "BB için Finalden ${gerekennotbb.toInt()}\n" +
                    "CB için Finalden ${gerekennotcb.toInt()}\n" +
                    "CC için Finalden ${gerekennotcc.toInt()}\n" +
                    "DC için Finalden ${gerekennotdc.toInt()}\n" +
                    "DD için Finalden ${gerekennotdd.toInt()}\n" +
                    "FD için Finalden ${gerekennotfd.toInt()}\n" +
                    "almanız gerekiyor"
            if (sort>100 || v>100 || f>100){
                bilgi.text="LÜTFEN [0-100] ARALIĞINDA DEĞER GİRİNİZ"
            }
            else if (sort>=60){
                when(ort){
                    in 0.0..38.0 -> not="FF  $gerekenbilgi"
                    in 39.0..45.0 -> not="FD  $gerekenbilgi"
                    in 46.0..52.0-> not="DD  $gerekenbilgi"
                    in 53.0..59.0-> not="DC  $gerekenbilgi"
                    in 60.0..66.0-> not="CC  $gerekenbilgi"
                    in 67.0..73.0-> not="CB  $gerekenbilgi"
                    in 74.0..80.0-> not="BB  $gerekenbilgi"
                    in 81.0..87.0-> not="BA  $gerekenbilgi"
                    in 88.0..100.0 -> not="AA  $gerekenbilgi"
                    else -> bilgi.text="LÜTFEN [0-100] ARALIĞINDA DEĞER GİRİRİNİZ"
                }
                bilgi.text= "NOTUNUZ:  $not  "
            }
            else if (sort<0){
                bilgi.text="LÜTFEN [0-100] ARALIĞINDA DEĞER GİRİNİZ"
            }
            else if (sort<60.0){
                if (sort>=35.0){
                    if (s<10){
                        for(i in 1..100){
                            var tskor=((60.0+((v*4.0/10.0+i*6.0/10.0)-sort))*(Math.pow((s/10.0),((-0.01)*((v*4.0/10.0+i*6.0/10.0)-sort))))).toInt()
                            if (tskor==(43.0+m).toInt()) not+="FD için alman gereken not: $i"
                            else if (tskor==(48.0+m).toInt()) not+="DD için alman gereken not: $i"
                            else if (tskor==(53.0+m).toInt()) not+="DC için alman gereken not: $i"
                            else if (tskor==(58.0+m).toInt()) not+="CC için alman gereken not: $i"
                            else if (tskor==(63.0+m).toInt()) not+="CB için alman gereken not: $i"
                            else if (tskor==(68.0+m).toInt()) not+="BB için alman gereken not: $i"
                            else if (tskor==(73.0+m).toInt()) not+="BA için alman gereken not: $i"
                            else if (tskor==(78.0+m).toInt()) not+="AA için alman gereken not: $i"
                            else not="Tekrar deneyiniz"
                            bilgi.text= "NOTUNUZ: $not"
                        }
                    }
                    else if (s>100){
                        bilgi.text="LÜTFEN [0-100] ARALIĞINDA DEĞER GİRİNİZ"
                    }
                    else{
                        val x=((0.5*s)+5.0)*(((v*4.0/10.0+f*6.0/10.0)-sort)/s)+60.0
                        if (x in (0.0)..(42.99+m)    ) harf="FF"
                        if (x in (43.00+m)..(47.99+m)) harf="FD"
                        if (x in (48.00+m)..(52.99+m)) harf="DD"
                        if (x in (53.00+m)..(57.99+m)) harf="DC"
                        if (x in (58.00+m)..(62.99+m)) harf="CC"
                        if (x in (63.00+m)..(67.99+m)) harf="CB"
                        if (x in (68.00+m)..(72.99+m)) harf="BB"
                        if (x in (73.00+m)..(77.99+m)) harf="BA"
                        if (x in (78.00+m)..(100.00) ) harf="AA"
                        for (i in 1..100){
                            val tskor=(((0.5*s)+5.0)*(((v*4.0/10.0+i*6.0/10.0)-sort)/s)+60.0).toInt()
                            not=""
                            if(tskor==43+m.toInt() && list.size==0) not="FD için Finalden alman gereken not: $i"
                            if(tskor==48+m.toInt() && list.size==1) not="DD için Finalden alman gereken not: $i"
                            if(tskor==53+m.toInt() && list.size==2) not="DC için Finalden alman gereken not: $i"
                            if(tskor==58+m.toInt() && list.size==3) not="CC için Finalden alman gereken not: $i"
                            if(tskor==63+m.toInt() && list.size==4) not="CB için Finalden alman gereken not: $i"
                            if(tskor==68+m.toInt() && list.size==5) not="BB için Finalden alman gereken not: $i"
                            if(tskor==73+m.toInt() && list.size==6) not="BA için Finalden alman gereken not: $i"
                            if(tskor==78+m.toInt() && list.size==7) not="AA için Finalden alman gereken not: $i"
                            if(not!=""){
                                list.add("$not")
                            }
                        }
                        var sonuc = "NOTUNUZ: $harf\n"
                        val aralik=list.size-1
                        for(i in aralik downTo 0){
                            sonuc+=list[i]+"\n"
                        }
                        bilgi.text=sonuc
                    }
                }
                else{
                    bilgi.text="BİR HATA OLDU. DEĞERLERİ KONTROL EDİN"
                }
            }
            else{
                bilgi.text="LÜTFEN [0-100] ARALIĞINDA DEĞER GİRİNİZ"
            }
        }
        catch (e :Exception){
            bilgi.text="ALANLAR BOŞ BIRAKILAMAZ.\nLÜTFEN DEĞERLERİ KONTROL EDİN"
        }

        closeKeyboard()
    }

    private fun closeKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}
//hint ve text yazı tipi ayrı ayrı değiştirme
//vize 55 üzeri girildiğinde sadece NOTUNUZ: CC yazıyor