package pandastudios.dotasound

import com.google.android.vending.expansion.downloader.impl.DownloaderService

// You must use the public key belonging to your publisher account
const val BASE64_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAncCy5ATSo+pNqZxPouCSJT0ySNObdm/2YZqfYB8Ao2dDMAIqvzz6LM0Myk3ldL+R7n68rZI96/djfrloh0o5SmBSHAJVHzjPEYUJuShzYo2RuOw8AGhkap509Uv8XKuD138iy3aiGcXOstxUnMnLacbBlKjyvQem/kzNvoiJRFSRsmrq0HopykQBfx0p2n0OCe7+A/0g/LQKM5VZ7SrV4UwlXKG3eEkozMtKTNEOSWu7nWjIZVhMAX+8kFAFpNzWB8GsAeDYZi6mE9teGb1XgvU7Ng6PKx4s0cCr0d1Zr6Aiw3A/CqVXk4WaPibQVveANoBWceNgv1ofzX+lKz4UmwIDAQAB"
// You should also modify this salt
val SALT = byteArrayOf(
        1, 42, -12, -1, 54, 98, -100, -12, 43, 2,
        -8, -4, 9, 5, -106, -107, -33, 45, -1, 84
)

class SampleDownloaderService : DownloaderService() {

    override fun getPublicKey(): String = BASE64_PUBLIC_KEY

    override fun getSALT(): ByteArray = SALT

    override fun getAlarmReceiverClassName(): String = SampleAlarmReceiver::class.java.name
}