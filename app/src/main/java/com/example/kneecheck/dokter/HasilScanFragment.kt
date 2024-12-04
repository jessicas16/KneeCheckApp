package com.example.kneecheck.dokter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.kneecheck.R
import com.example.kneecheck.databinding.FragmentHasilScanBinding

class HasilScanPasienFragment : Fragment() {

    private lateinit var binding: FragmentHasilScanBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize ViewBinding
        binding = FragmentHasilScanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val confidenceScore = arguments?.getFloat("confidenceScore")
        val label = arguments?.getString("label")
        val idXray = arguments?.getString("id_xray")
        val imgPath = arguments?.getString("img_path")
        val pengobatan = arguments?.getString("pengobatan")

        // Update the UI with the result
        binding.severityText.text = "Confidence: $confidenceScore"
        binding.tipsText.text = "Pengobatan: $pengobatan"
    }
}
