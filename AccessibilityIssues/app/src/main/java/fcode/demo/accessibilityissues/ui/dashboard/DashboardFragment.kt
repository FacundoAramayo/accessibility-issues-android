package fcode.demo.accessibilityissues.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.IMPORTANT_FOR_ACCESSIBILITY_YES
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import fcode.demo.accessibilityissues.R
import fcode.demo.accessibilityissues.databinding.FragmentDashboardBinding
import fcode.demo.accessibilityissues.ui.form.FormActivity

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        binding.actionButton.contentDescription = getString(R.string.go_to_subscribe_form)
        binding.actionButton.setOnClickListener {
            val intent = Intent(activity, FormActivity::class.java)
            requireActivity().startActivity(intent)
        }

        binding.discount.contentDescription = getString(R.string.discount_param, "15%")

        binding.imageView.importantForAccessibility = IMPORTANT_FOR_ACCESSIBILITY_YES
        binding.imageView.contentDescription = getString(R.string.save_money_now)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}