package nit2x.paba.projrabu

import android.os.Parcel
import android.os.Parcelable

data class dcContact (
        val Nama : String?,
        val NoTel : String?,
        val Alamat : String?
    ) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Nama)
        parcel.writeString(NoTel)
        parcel.writeString(Alamat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<dcContact> {
        override fun createFromParcel(parcel: Parcel): dcContact {
            return dcContact(parcel)
        }

        override fun newArray(size: Int): Array<dcContact?> {
            return arrayOfNulls(size)
        }
    }
}
