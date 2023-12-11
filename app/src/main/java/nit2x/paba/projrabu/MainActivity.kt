package nit2x.paba.projrabu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    val dataContact : Array<dcContact?> = arrayOfNulls<dcContact>(10)
    var isi = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val _ivSatu = findViewById<ImageView>(R.id.ivSatu)
        val _ivDua = findViewById<ImageView>(R.id.ivDua)
        val _ivTiga = findViewById<ImageView>(R.id.ivTiga)
        val _ivEmpat = findViewById<ImageView>(R.id.ivEmpat)
        val _ivLima = findViewById<ImageView>(R.id.ivLima)

        val mFragmentManager = supportFragmentManager
        val mfragSatu = fragmentSatu()
        val mfragDua = fragmentDua()
        val mfragTiga = fragmentTiga()
        val mfragEmpat = fragmentEmpat()
        val mfragLima = fragmentLima()

        mFragmentManager.findFragmentByTag(fragmentTiga::class.java.simpleName)
        mFragmentManager
            .beginTransaction()
            .add(R.id.frameLay, mfragTiga, fragmentTiga::class.java.simpleName)
            .commit()

        _ivSatu.setOnClickListener {
            mFragmentManager.findFragmentByTag(fragmentSatu::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .replace(R.id.frameLay, mfragSatu, fragmentSatu::class.java.simpleName)
                .commit()
        }

        _ivDua.setOnClickListener {
            mFragmentManager.findFragmentByTag(fragmentDua::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .replace(R.id.frameLay, mfragDua, fragmentDua::class.java.simpleName)
                .commit()
        }

        _ivTiga.setOnClickListener {
            mFragmentManager.findFragmentByTag(fragmentTiga::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .replace(R.id.frameLay, mfragTiga, fragmentTiga::class.java.simpleName)
                .commit()
        }

        _ivEmpat.setOnClickListener {
            mFragmentManager.findFragmentByTag(fragmentEmpat::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .replace(R.id.frameLay, mfragEmpat, fragmentEmpat::class.java.simpleName)
                .commit()
        }

        _ivLima.setOnClickListener {
            mFragmentManager.findFragmentByTag(fragmentLima::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .replace(R.id.frameLay, mfragLima, fragmentLima::class.java.simpleName)
                .commit()
        }
    }

    fun tambahData(Nama: String, NoTel: String, Alamat : String) {
        if (isi==10) isi=0
        dataContact[isi++] = dcContact(Nama,NoTel,Alamat)
        Log.d("ISI", isi.toString())
    }
}