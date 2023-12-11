package nit2x.paba.projrabu

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginBottom

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragmentDua.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragmentDua : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dua, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val linearLayout = view.findViewById<LinearLayout>(R.id.dataLinear)

        var textViewnamaArray = arrayOfNulls<TextView>(10)
        var textViewalamatArray = arrayOfNulls<TextView>(10)
        var i=0;
        for (isidc in ( super.requireActivity() as MainActivity).dataContact) {

            val textView_nama = TextView(this.requireActivity()).apply {
                layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)
                text = isidc?.Nama ?: ""
                textSize = 40F
                setTypeface(null, Typeface.BOLD)
            }
            val textView_alamat  = TextView(this.requireActivity()).apply {
                layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)
                text = isidc?.Alamat ?: ""
                textSize = 25F
            }
            linearLayout.addView(textView_nama)
            linearLayout.addView(textView_alamat)
            textViewnamaArray[i] = textView_nama
            textViewalamatArray[i] = textView_alamat
            i=i+1
        }

        for (i in textViewnamaArray.indices) {
            textViewnamaArray[i]?.setOnClickListener {
                Toast.makeText(this.requireActivity(), "TextView $i clicked!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragmentDua.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragmentDua().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}