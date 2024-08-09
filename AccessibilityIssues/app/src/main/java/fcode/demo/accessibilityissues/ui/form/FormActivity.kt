package fcode.demo.accessibilityissues.ui.form

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fcode.demo.accessibilityissues.databinding.ActivityFormBinding


class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.actionButton.setOnClickListener {
            finish()
        }
    }

}
