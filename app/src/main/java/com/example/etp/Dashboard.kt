package com.example.etp



import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.cardview.widget.CardView

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val menuIcon = findViewById<View>(R.id.menu_icon)
        menuIcon.setOnClickListener {
            showPopupMenu(it)
        }


        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }

        // Card Clicks
        val landHoldingCard = findViewById<LinearLayout>(R.id.landHoldingCard)
        val irrigationCard = findViewById<LinearLayout>(R.id.irrigationCard)
        val croppingCard = findViewById<LinearLayout>(R.id.croppingCard)
        val trendsCard = findViewById<LinearLayout>(R.id.trendsCard)

        landHoldingCard.setOnClickListener {
            Toast.makeText(this, "Land Holding clicked", Toast.LENGTH_SHORT).show()
             startActivity(Intent(this, LandHoldingActivity::class.java))
        }

        irrigationCard.setOnClickListener {
            Toast.makeText(this, "Irrigation clicked", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, IrrigationActivity::class.java))        }

        croppingCard.setOnClickListener {
            Toast.makeText(this, "Cropping Patterns clicked", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, CroppingPatterns::class.java))
        }

        trendsCard.setOnClickListener {
            Toast.makeText(this, "Trends clicked", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, TrendsActivity::class.java))

        }
    }

    private fun showPopupMenu(view: View) {
        val popup = PopupMenu(this, view)
        popup.menuInflater.inflate(R.menu.dashboard_menu, popup.menu)

        popup.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.menu_about -> {
                    showInfoDialog("About", "LandLens helps analyze land, irrigation, cropping, and trends.")
                    true
                }
                R.id.menu_help -> {
                    showInfoDialog("Help", "Need help? Contact us at support@landlens.com")
                    true
                }
                R.id.menu_exit -> {
                    confirmExit()
                    true
                }
                else -> false
            }
        }

        popup.show()
    }

    private fun showInfoDialog(title: String, message: String) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }


    private fun confirmExit() {
        AlertDialog.Builder(this)
            .setTitle("Exit App")
            .setMessage("Are you sure you want to exit?")
            .setPositiveButton("Yes") { _: DialogInterface, _: Int ->
                finishAffinity() // Exit app
            }
            .setNegativeButton("No", null)
            .show()
    }
}