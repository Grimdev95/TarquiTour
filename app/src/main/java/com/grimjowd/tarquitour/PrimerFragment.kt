package com.grimjowd.tarquitour

import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
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
 * Use the [PrimerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PrimerFragment : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener

    private lateinit var txtemail: EditText
    private lateinit var txtpass: EditText
    private lateinit var passwordVisibilityImageView: ImageView

    private var isPasswordVisible = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_primer, container, false)

        txtemail = rootView.findViewById(R.id.edtEmail)
        txtpass = rootView.findViewById(R.id.edtPassword)
        val txtnameuser = rootView.findViewById<EditText>(R.id.nombreusertxt)
        val btnenviar = rootView.findViewById<Button>(R.id.btnenviar)
        passwordVisibilityImageView =
            rootView.findViewById<ImageView>(R.id.passwordVisibilityImageView)

        firebaseAuth = Firebase.auth

        btnenviar.setOnClickListener {
            val nombre = txtnameuser.text.toString()
            val email = txtemail.text.toString()
            val password = txtpass.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                if (isValidEmail(email)) {
                    signIn(email, password, nombre)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Ingrese un correo electrónico válido",
                        Toast.LENGTH_SHORT
                    ).show()
                    txtemail.text.clear()
                    txtpass.text.clear()
                    txtnameuser.text.clear()
                }
            } else {
                Toast.makeText(
                    requireContext(),
                    "Ingrese el correo electrónico y la contraseña",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        passwordVisibilityImageView.setOnClickListener {
            isPasswordVisible = !isPasswordVisible

            if (isPasswordVisible) {
                txtpass.transformationMethod = null
                passwordVisibilityImageView.setImageResource(R.drawable.ic_look)
            } else {
                txtpass.transformationMethod = PasswordTransformationMethod.getInstance()
                passwordVisibilityImageView.setImageResource(R.drawable.ic_look)
            }

            txtpass.setSelection(txtpass.text.length)
        }

        return rootView
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun signIn(email: String, password: String, nombre: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    val verifica = user?.isEmailVerified
                    if (verifica == true) {
                        Toast.makeText(
                            requireContext(),
                            "¡Bienvenido, Has iniciado sesión correctamente",
                            Toast.LENGTH_SHORT
                        ).show()
                        val intent = Intent(requireContext(), MainActivity::class.java)
                        intent.putExtra("nombreusertxt", nombre)
                        startActivity(intent)
                    } else {
                        // Reenviar correo de verificación
                        user?.sendEmailVerification()
                        Toast.makeText(
                            requireContext(),
                            "Por favor, verifica tu correo antes de iniciar sesión. Se ha reenviado el correo de verificación.",
                            Toast.LENGTH_SHORT
                        ).show()
                        // Limpia los campos de correo y contraseña
                        txtemail.text.clear()
                        txtpass.text.clear()
                    }
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Error de email y/o contraseña",
                        Toast.LENGTH_SHORT
                    ).show()
                    txtpass.text.clear()
                }
            }
    }
}