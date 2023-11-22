package com.grimjowd.tarquitour

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TercerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TercerFragment : Fragment() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener
    private lateinit var edtrestartemail: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_tercer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edtrestartemail = view.findViewById(R.id.edemailrecuperar)
        val btnrestart = view.findViewById<Button>(R.id.btnrestablecer)

        firebaseAuth = Firebase.auth

        btnrestart.setOnClickListener {
            val email = edtrestartemail.text.toString()

            if (isEmailValid(email)) {
                sendPasswordReset(email)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Error, ingresa un correo electrónico válido",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun isEmailValid(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }

    private fun sendPasswordReset(email: String) {
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(
                    requireContext(),
                    "Se ha enviado un enlace para recuperar la contraseña a tu correo electrónico",
                    Toast.LENGTH_SHORT
                ).show()
                // Limpiar el campo de email después de enviar el restablecimiento de contraseña exitosamente
                edtrestartemail.text.clear()

            } else {
                Toast.makeText(
                    requireContext(),
                    "Error en recuperar la contraseña",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
