package com.example.iteration1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.iteration1.ui.theme.Iteration1Theme
import com.example.iteration1.ui.theme.green200
import com.example.iteration1.ui.theme.green200
import com.example.iteration1.ui.theme.green700

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent () {
            Iteration1Theme {
                // A surface container using the 'background' color from the theme
                myapp()
            }
        }
    }
}
@Composable
fun myapp()
{
    var Loginvaribale by remember{ mutableStateOf(false) }
    var shouldShowOnboarding by remember { mutableStateOf(true) }
    if(shouldShowOnboarding)
    {
        OnboardingScreen(myfunction = {shouldShowOnboarding=false})
    }else if(shouldShowOnboarding==false && Loginvaribale==false)
    {
        Login(newfunction = { shouldShowOnboarding=true }, newfunction2 = {Loginvaribale=true})

    }
    else
    {
        register (newfunction = {Loginvaribale=false})
    }

}

// Registartion page code below

@Composable
fun MangroveRegistration() {

    var name by rememberSaveable { mutableStateOf("") }
    var phone_number by rememberSaveable { mutableStateOf("") }
    var location by rememberSaveable { mutableStateOf("") }
    var crops by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var passw by rememberSaveable { mutableStateOf("") }
    var confpassw by rememberSaveable { mutableStateOf("") }

    Column() {

        Text(text = stringResource(id = R.string.app_name),
            color = green700,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .width(150.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 30.dp, bottom = 20.dp)
        )

        Text(text = stringResource(id = R.string.name),
            color = Color.Gray,
            modifier = Modifier
                .padding(start = 30.dp)
        )

        NameTextField(name = name, changed = { name = it })


        Text(text = stringResource(id = R.string.phone_no),
            color = Color.Gray,
            modifier = Modifier
                .padding(start = 30.dp)

        )

        PhoneTextField(phone_number = phone_number, changed = { phone_number = it })


        Text(text = stringResource(id = R.string.location),
            color = Color.Gray,
            modifier = Modifier
                .padding(start = 30.dp)

        )
        LocationTextField(location = location, changed = { location = it })


        Text(text = stringResource(id = R.string.crops),
            color = Color.Gray,
            modifier = Modifier
                .padding(start = 30.dp)

        )
        CropsTextField(crops = crops, changed = { crops = it })



        Text(text = stringResource(id = R.string.Email),
            color = Color.Gray,
            modifier = Modifier
                .padding(start = 30.dp)

        )
        emailTextField(email = email, changed = { email = it })


        Text(text = stringResource(id = R.string.Password),
            color = Color.Gray,
            modifier = Modifier
                .padding(start = 30.dp)

        )
        PasswTextField(password = passw, changed = { passw = it })


        Text(text = stringResource(id = R.string.confpassw),
            color = Color.Gray,
            modifier = Modifier
                .padding(start = 30.dp)

        )
        ConfirmPasswTextField(confpassword = confpassw, changed = { confpassw = it })

        RegisterButton() {}

    }
}





@Composable
fun NameTextField (name:String, changed: (String) -> Unit){
    TextField (
        value = name,
        onValueChange = changed,
//        label = { Text(text = stringResource(id = R.string.name)) },
        modifier = Modifier
            .padding(start = 30.dp, top = 10.dp),
        shape = RoundedCornerShape(15.dp),
    )

}

@Composable
fun PhoneTextField(phone_number: String, changed: (String) -> Unit ) {
    TextField(
        value = phone_number,
        onValueChange = changed,
//        label = { Text (text = stringResource(id = R.string.enterpass)) },
        modifier = Modifier
            .padding(start = 30.dp, top = 10.dp),
        shape = RoundedCornerShape(15.dp)
    )
}


@Composable
fun LocationTextField(location: String, changed: (String) -> Unit ) {
    TextField(
        value = location,
        onValueChange = changed,
//        label = { Text (text = stringResource(id = R.string.enterpass)) },
        modifier = Modifier
            .padding(start = 30.dp, top = 10.dp),
        shape = RoundedCornerShape(15.dp)
    )
}

@Composable
fun CropsTextField(crops: String, changed: (String) -> Unit ) {
    TextField(
        value = crops,
        onValueChange = changed,
//        label = { Text (text = stringResource(id = R.string.enterpass)) },
        modifier = Modifier
            .padding(start = 30.dp, top = 10.dp),
        shape = RoundedCornerShape(15.dp)
    )
}

@Composable
fun emailTextField (email:String, changed: (String) -> Unit){
    TextField (
        value = email,
        onValueChange = changed,
//        label = { Text(text = stringResource(id = R.string.enteremail))},

        modifier = Modifier
//            .fillMaxWidth()
            .padding(start = 30.dp, top = 10.dp),
        shape = RoundedCornerShape(15.dp),
    )
}

@Composable
fun PasswTextField(password: String, changed: (String) -> Unit ) {
    TextField(
        value = password,
        onValueChange = changed,
//        label = { Text (text = stringResource(id = R.string.enterpass)) },
        modifier = Modifier
//            .fillMaxWidth()
            .padding(start = 30.dp, top = 10.dp),
        shape = RoundedCornerShape(15.dp)
    )
}

@Composable
fun ConfirmPasswTextField(confpassword: String, changed: (String) -> Unit ) {
    TextField(
        value = confpassword,
        onValueChange = changed,
//        label = { Text (text = stringResource(id = R.string.enterpass)) },
        modifier = Modifier
//            .fillMaxWidth()
            .padding(start = 30.dp, top = 10.dp),
        shape = RoundedCornerShape(15.dp)
    )
}


@Composable
fun RegisterButton(clicked: () -> Unit){
    Button(onClick = clicked,
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = green700,
            contentColor = Color.White
        ),
        modifier = Modifier
            .padding(start = 30.dp, top = 10.dp)

    ) {
        Text(text = stringResource(id = R.string.register),
            textAlign = TextAlign.Center

        )


    }
}

// Bellow Login code
@Composable
fun MangroveScreen() {

    var username by remember { mutableStateOf("") }

    var password by rememberSaveable { mutableStateOf("") }


    Column() {

        Text(text = stringResource(id = R.string.app_name),
            color = green700,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .width(150.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 40.dp, bottom = 20.dp)
        )

        Text(text = stringResource(id = R.string.Email),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 30.dp, top = 10.dp, bottom= 10.dp)
        )

        EmailTextField(username = username, changed = { username = it })

        Text(text = stringResource(id = R.string.Password),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 30.dp, top = 10.dp, bottom= 10.dp, end = 20.dp)

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
        label = { Text(text = stringResource(id = R.string.enteremail))},

        modifier = Modifier
//            .fillMaxWidth()
            .padding(start = 30.dp, top = 10.dp, bottom = 10.dp, end = 20.dp),
        shape = RoundedCornerShape(15.dp),

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
//            .fillMaxWidth()
            .padding(start = 30.dp, top = 10.dp, bottom = 10.dp, end = 20.dp),
        shape = RoundedCornerShape(15.dp)
    )
}
@Composable
fun LoginButton(clicked: () -> Unit){
    Button(onClick = clicked,
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = green700,
            contentColor = Color.White
        ),
        modifier = Modifier
            .padding(start = 30.dp, top = 10.dp)

    ) {
        Text(text = stringResource(id = R.string.loginbutton),
            textAlign = TextAlign.Center

        )
    }
}


@Composable
fun register(newfunction:()->Unit)
{

    Button(onClick =newfunction,
        colors = ButtonDefaults.buttonColors(backgroundColor = green700))
    {
        Text(stringResource(id = R.string.button2))
    }
    MangroveRegistration()
}

@Composable
fun Login(newfunction:()->Unit,newfunction2: () -> Unit)
{

 Row(modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colors.secondary))
 {
     Button(onClick =newfunction,
         colors = ButtonDefaults.buttonColors(backgroundColor = green700))
     {
         Text(stringResource(id = R.string.button2))
     }
     Spacer(modifier = Modifier.padding(horizontal = 10.dp))
     Button(onClick =newfunction2,
         colors = ButtonDefaults.buttonColors(backgroundColor = green700))
     {
         Text(stringResource(id = R.string.button3))
     }
 }

    MangroveScreen()

}

// Onboarding screen code below
@Composable
fun OnboardingScreen(myfunction:()->Unit) {
    // TODO: This state should be hoisted

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row()
        {
            Text(text=stringResource(id = R.string.logText), fontSize = 30.sp,fontWeight = FontWeight.Bold)
            Text(text=stringResource(id = R.string.logoText1), fontSize = 30.sp,fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Text(text=stringResource(id = R.string.solution), fontSize = 20.sp)
        Text(text=stringResource(id = R.string.solution2), fontSize = 20.sp)

        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Image(painter = painterResource(id = R.drawable.captureapp),
            contentDescription = stringResource(id = R.string.onboardImage),
            modifier = Modifier.size(450.dp)
        )

        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = green700),
            onClick = myfunction
        ) {
            Text(stringResource(id = R.string.ButtonText))
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    OnboardingScreen(myfunction ={})
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Iteration1Theme {
        myapp()
    }
}