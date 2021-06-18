package co.nimblehq.rxjava.storage

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import javax.inject.Inject

// TODO: For demo purpose only, replace with actual value that needs to be stored securely
private const val PREF_TEST_ID = "PREF_TEST_ID"

class BaseSecuredStorageImpl @Inject constructor(applicationContext: Context) : BaseSecuredStorage {

    private var encryptedSharedPreferences: SharedPreferences

    init {
        val masterKey = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        encryptedSharedPreferences = EncryptedSharedPreferences.create(
            "app_secret_shared_prefs",
            masterKey,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    // TODO: For demo purpose only, replace with actual value that needs to be stored securely
    override fun getTestId(): String? {
        return encryptedSharedPreferences.getString(PREF_TEST_ID, null)
    }

    // TODO: For demo purpose only, replace with actual value that needs to be stored securely
    override fun saveTestId(testId: String) {
        with(encryptedSharedPreferences.edit()) {
            putString(PREF_TEST_ID, testId)
            apply()
        }
    }

    override fun clearAllData() {
        with(encryptedSharedPreferences.edit()) {
            clear()
            apply()
        }
    }
}