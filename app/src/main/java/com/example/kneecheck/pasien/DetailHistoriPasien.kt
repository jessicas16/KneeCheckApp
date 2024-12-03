package com.example.kneecheck.pasien

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kneecheck.R

/**
 * A simple [Fragment] subclass.
 * Use the [DetailHistoriPasien.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailHistoriPasien : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(com.example.kneecheck.pasien.uipasien.ARG_PARAM1)
            param2 = it.getString(com.example.kneecheck.pasien.uipasien.ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_histori_pasien, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailHistoriPasien.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailHistoriPasien().apply {
                arguments = Bundle().apply {
                    putString(com.example.kneecheck.pasien.uipasien.ARG_PARAM1, param1)
                    putString(com.example.kneecheck.pasien.uipasien.ARG_PARAM2, param2)
                }
            }
    }
}