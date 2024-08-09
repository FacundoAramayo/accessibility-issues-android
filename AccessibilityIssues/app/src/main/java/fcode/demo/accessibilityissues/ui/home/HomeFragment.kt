package fcode.demo.accessibilityissues.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import fcode.demo.accessibilityissues.R
import fcode.demo.accessibilityissues.databinding.FragmentHomeBinding
import fcode.demo.accessibilityissues.ui.form.FormActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.termsAndConditions.text = getString(R.string.terms_and_conditions, "15%")

        binding.actionButton.setOnClickListener {
            val intent = Intent(activity, FormActivity::class.java)
            requireActivity().startActivity(intent)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}