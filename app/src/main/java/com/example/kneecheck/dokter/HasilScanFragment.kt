package com.example.kneecheck.dokter

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

    private fun showConfirmationDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.layout_popup, null)
        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(false) // Dialog tidak bisa ditutup dengan klik di luar
            .create()

        // Klik tombol "Belum"
        val buttonBelum = dialogView.findViewById<Button>(R.id.btnBelum)
        buttonBelum.setOnClickListener {
            dialog.dismiss()
            // Arahkan ke halaman Belum Punya Akun
            val intent = Intent(this, BelumPunyaAkunFragment::class.java)
            startActivity(intent)
        }

        // Klik tombol "Sudah"
        val buttonSudah = dialogView.findViewById<Button>(R.id.btnSudah)
        buttonSudah.setOnClickListener {
            dialog.dismiss()
            // Arahkan ke halaman Sudah Punya Akun
            val intent = Intent(this, SudahPunyaAkunFragment::class.java)
            startActivity(intent)
        }

        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent) // Background transparan
        dialog.show()
    }

}
