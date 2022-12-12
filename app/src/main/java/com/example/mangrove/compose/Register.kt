package com.example.mangrove.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import com.example.mangrove.ui.theme.logo1

@Composable
fun RegisterProject()
{
    var username by remember { mutableStateOf("") }
    var username1 by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var crop by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confpassword by rememberSaveable { mutableStateOf("") }
    Scaffold() {
    }
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = stringResource(id = R.string.man),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center,
                fontSize = 35.sp)
            Text(text = stringResource(id = R.string.grove),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onSecondary,
                textAlign = TextAlign.Center,
                fontSize = 35.sp)
        }

        Spacer(modifier = Modifier.height(7.dp))
        Text(text = stringResource(id = R.string.username),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 60.dp, top = 30.dp)
        )
        NameTextField(name = username1, changed = {username1=it})

        Text(text = stringResource(id = R.string.phone),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 60.dp)
        )
        PhoneTextField(phone = phone, changed = {phone=it})

        Text(text = stringResource(id = R.string.location),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 60.dp)
        )
        LocationTextField(location = location, changed = {location=it})

        Text(text = stringResource(id = R.string.crop),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 60.dp)
        )
        CropTextField(crop = crop, changed = {crop=it})


        Text(text = stringResource(id = R.string.Email),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 60.dp)
        )
        EmailTextField1(username = username, changed = { username = it })
        Text(text = stringResource(id = R.string.Password),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 60.dp, bottom= 10.dp, end = 20.dp)
        )
        PasswordTextField1(password = password, changed = { password = it })
        Text(text = stringResource(id = R.string.confpassword),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 60.dp, bottom= 10.dp, end = 20.dp)
        )
        ConfPassTextField(confpassword = confpassword,changed = { confpassword = it })

        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondaryVariant,
                contentColor = Color.White
            ),
            modifier = Modifier
                .padding(start = 60.dp)
        ) {
            Text(text = stringResource(id = R.string.registerbutton),
                textAlign = TextAlign.Center, color = Color.Black
            )
        }

    }

}
@Composable
fun NameTextField(name: String, changed: (String) -> Unit ) {
    TextField(
        value = name,
        onValueChange = changed,
        label = { Text (text = stringResource(id = R.string.entername)) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .padding(start = 60.dp, bottom = 10.dp, end = 20.dp),
    )
}
@Composable
fun PhoneTextField(phone: String, changed: (String) -> Unit ) {
    TextField(
        value = phone,
        onValueChange = changed,
        label = { Text (text = stringResource(id = R.string.enterphone)) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .padding(start = 60.dp, bottom = 10.dp, end = 20.dp),
    )
}
@Composable
fun LocationTextField(location: String, changed: (String) -> Unit ) {
    TextField(
        value = location,
        onValueChange = changed,
        label = { Text (text = stringResource(id = R.string.enterlocation)) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .padding(start = 60.dp, bottom = 10.dp, end = 20.dp),
    )
}
@Composable
fun CropTextField(crop: String, changed: (String) -> Unit ) {
    TextField(
        value = crop,
        onValueChange = changed,
        label = { Text (text = stringResource(id = R.string.entercrop)) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .padding(start = 60.dp, bottom = 10.dp, end = 20.dp),
    )
}


@Composable
fun EmailTextField1 (username:String, changed: (String) -> Unit){
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
fun PasswordTextField1(password: String, changed: (String) -> Unit ) {
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
fun ConfPassTextField(confpassword: String, changed: (String) -> Unit ) {
    TextField(
        value =confpassword,
        onValueChange = changed,
        label = { Text (text = stringResource(id = R.string.enterConfpass)) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .padding(start = 60.dp, bottom = 10.dp, end = 20.dp),
    )
}

@Composable
fun RegisterButton(clicked: () -> Unit){
    Button(onClick = {},
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondaryVariant,
            contentColor = Color.White
        ),
        modifier = Modifier
            .padding(start = 60.dp, top = 50.dp)

    ) {
        Text(text = stringResource(id = R.string.registerbutton),
            textAlign = TextAlign.Center, color = Color.Black
        )
    }
}