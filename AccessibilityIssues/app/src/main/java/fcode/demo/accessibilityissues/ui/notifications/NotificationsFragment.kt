package fcode.demo.accessibilityissues.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import fcode.demo.accessibilityissues.R
import fcode.demo.accessibilityissues.databinding.FragmentNotificationsBinding
import fcode.demo.accessibilityissues.ui.form.FormActivity

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)

        val itemList = listOf(
            NotificationItem(getString(R.string.discount_voucher, "15%"), "01/08/2024", getString(R.string.terms_and_conditions, "15%"), true),
            NotificationItem(getString(R.string.discount_voucher, "9%"), "01/07/2024", getString(R.string.terms_and_conditions, "9%"), false),
            NotificationItem(getString(R.string.refer_a_friend), "12/06/2024", getString(R.string.refer_a_friend_description), true),
            NotificationItem(getString(R.string.welcome_to_finance_app), "12/06/2024", getString(R.string.your_financial_companion), false)
        )

        val adapter = Adapter(itemList) {
            val intent = Intent(activity, FormActivity::class.java)
            requireActivity().startActivity(intent)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}