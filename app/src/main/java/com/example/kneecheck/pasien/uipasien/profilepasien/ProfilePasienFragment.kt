package com.example.kneecheck.pasien.uipasien.profilepasien

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kneecheck.databinding.FragmentProfilePasienBinding

class ProfilePasienFragment : Fragment() {

    private var _binding: FragmentProfilePasienBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(ProfilePasienViewModel::class.java)

        _binding = FragmentProfilePasienBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textProfilePasien
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}