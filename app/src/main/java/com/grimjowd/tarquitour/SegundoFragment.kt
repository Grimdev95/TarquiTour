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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.auth.User
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SegundoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SegundoFragment : Fragment() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var dataRef: DatabaseReference
    private lateinit var usuariosRef: DatabaseReference

    // Declara las variables como propiedades de clase
    private lateinit var edtnombre: EditText
    private lateinit var edTelefono: EditText
    private lateinit var edtemail: EditText
    private lateinit var edtpassword: EditText
    private lateinit var edtpasswords: EditText
    private lateinit var edtdireccion: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_segundo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edtnombre = view.findViewById(R.id.edNombre)
        edTelefono = view.findViewById(R.id.edTelefono)
        edtemail = view.findViewById(R.id.edEmail)
        edtpassword = view.findViewById(R.id.edpassword)
        edtpasswords = view.findViewById(R.id.edPasswords)
        edtdireccion = view.findViewById(R.id.edDireccion)
        val btncrearcuenta = view.findViewById<Button>(R.id.btnCrearcuenta)

        firebaseAuth = Firebase.auth
        database = FirebaseDatabase.getInstance()
        dataRef = database.getReference("data")
        usuariosRef = dataRef.child("usuarios")

        btncrearcuenta.setOnClickListener {
            val nombre = edtnombre.text.toString()
            val cell = edTelefono.text.toString()
            val email = edtemail.text.toString()
            val password = edtpassword.text.toString()
            val confirmPassword = edtpasswords.text.toString()
            val direccion = edtdireccion.text.toString()

            if (nombre.isNotEmpty() && cell.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty() && direccion.isNotEmpty()) {
                if (password == confirmPassword) {
                    if (isPasswordValid(password)) {
                        createAccount(email, password, nombre, direccion)
                    }
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Error, las contraseñas no coinciden",
                        Toast.LENGTH_SHORT
                    ).show()
                    edtpassword.requestFocus()
                }
            } else {
                Toast.makeText(
                    requireContext(),
                    "Error, todos los campos deben ser completados",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun isPasswordValid(password: String): Boolean {
        val passwordPattern = "(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{10,}"
        val isValid = password.matches(passwordPattern.toRegex())

        if (!isValid) {
            val message = "La contraseña debe cumplir con los siguientes requisitos:\n" +
                    "- Al menos una letra mayúscula o minúscula.\n" +
                    "- Al menos un dígito.\n" +
                    "- Longitud mínima de 10 caracteres."

            Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
        }
        return isValid
    }

    private fun createAccount(email: String, password: String, nombre: String, direccion: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    val userId = firebaseAuth.currentUser?.uid

                    val user = User(
                        userId,
                        nombre,
                        edTelefono.text.toString(),
                        email,
                        password,
                        null,
                        direccion
                    )
                    if (userId != null) {
                        val usuariosRef = dataRef.child("usuarios")
                        usuariosRef.child(userId).setValue(user)
                            .addOnSuccessListener {
                                // saveTokenToFirebase() // Eliminado el llamado al método
                                sendEmailVerification()
                                Toast.makeText(
                                    requireContext(),
                                    "¡Su cuenta ha sido creada exitosamente, se requiere verificación en su Email!",
                                    Toast.LENGTH_SHORT
                                ).show()
                                // Limpiar los campos después de crear la cuenta exitosamente
                                edtnombre.text.clear()
                                edTelefono.text.clear()
                                edtemail.text.clear()
                                edtpassword.text.clear()
                                edtpasswords.text.clear()
                                edtdireccion.text.clear()
                            }
                            .addOnFailureListener { exception ->
                                Toast.makeText(
                                    requireContext(),
                                    "Error al guardar los datos en la base de datos: $exception",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Error al obtener el ID del usuario",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Error al crear la cuenta: " + task.exception,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    private fun sendEmailVerification() {
        val user = firebaseAuth.currentUser!!
        user.sendEmailVerification().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // El correo de verificación se envió exitosamente
            } else {
                // Error al enviar el correo de verificación
            }
        }
    }
}