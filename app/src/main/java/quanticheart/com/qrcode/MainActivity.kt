package quanticheart.com.qrcode

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import quanticheart.com.qrcode2.BarcodeCaptureActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            val intent = Intent(applicationContext, BarcodeCaptureActivity::class.java)
            intent.putExtra(BarcodeCaptureActivity.AutoFocus, true)
//            intent.putExtra(BarcodeCaptureActivity.UseFlash, true)
            intent.putExtra(BarcodeCaptureActivity.OnlyQRCode, true)
            startActivityForResult(intent, 10)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 10) {
            /* if (resultCode == BarcodeCaptureActivity.QRCODE_SUCCESS) {
                 if (data != null) {
                     val barcode = data.getParcelableExtra<BarcodeData>(BarcodeCaptureActivity.BarcodeObject)
                     val p = barcode.cornerPoints
                     textView.text = barcode.displayValue
                 } else
                     textView.text = "Not result"
             } else*/
            if (resultCode == BarcodeCaptureActivity.QRCODE_STRING_SUCCESS) {
                if (data != null) {
                    val barcode = data.getStringExtra(BarcodeCaptureActivity.BarcodeString)
                    textView.text = barcode
                } else
                    textView.text = "Not result"
            } else {
//                Log.e(LOG, String.format(getString(R.string.barcode_error_format),
//                    CommonStatusCodes.getStatusCodeString(resultCode)))}
            }
        } else
            super.onActivityResult(requestCode, resultCode, data)
    }
}
