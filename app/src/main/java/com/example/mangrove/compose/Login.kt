package com.example.mangrove.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mangrove.R

@Composable
fun LoginProject()
{
    var username by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    Scaffold() {

    }

    Column() {


        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = stringResource(id = R.string.man),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center,
                fontSize = 35.sp)
            Text(text = stringResource(id = R.string.grove),
                fontWeight = FontWeight.Bold,
                color =MaterialTheme.colors.onSecondary,
                textAlign = TextAlign.Center,
                fontSize = 35.sp)
        }
        Spacer(modifier = Modifier.height(7.dp))
        Text(text = stringResource(id = R.string.Email),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 60.dp, top = 80.dp)
        )
        EmailTextField(username = username, changed = { username = it })
        Text(text = stringResource(id = R.string.Password),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 60.dp, bottom= 10.dp, end = 20.dp)
        )
        PasswordTextField(password = password, changed = { password = it })
        LoginButton (){}

    }

}


@Composable
fun EmailTextField (username:String, changed: (String) -> Unit){
    TextField (
        value = username,
        onValueChange = changed,
        label = { Text(text = stringResource(id = R.string.enteremail)) },

        modifier = Modifier
            .padding(start = 60.dp, bottom = 10.dp, end = 20.dp),
        shape = RoundedCornerShape(5.dp),

        )
}


@Composable
fun PasswordTextField(password: String, changed: (String) -> Unit ) {
    TextField(
        value = password,
        onValueChange = changed,
        label = { Text (text = stringResource(id = R.string.enterpass)) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .padding(start = 60.dp, bottom = 10.dp, end = 20.dp),
    )
}
@Composable
fun LoginButton(clicked: () -> Unit){
    Button(onClick = clicked,
        colors = ButtonDefaults.buttonColors(
            backgroundColor =MaterialTheme.colors.secondaryVariant,
            contentColor = Color.White
        ),
        modifier = Modifier
            .padding(start = 60.dp, top = 50.dp)

    ) {
        Text(text = stringResource(id = R.string.loginbutton),
            textAlign = TextAlign.Center, color = Color.Black
        )
    }
}
