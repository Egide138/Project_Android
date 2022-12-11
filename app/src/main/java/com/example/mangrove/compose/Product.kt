package com.example.mangrove.compose

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
//import androidx.compose.runtime.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mangrove.Model.ViewModelProduct
import com.example.mangrove.Model.product
import com.example.mangrove.R
import com.example.mangrove.ui.theme.MangroveTheme
import java.util.*

@Composable
fun ProductScreen() {
    val viewModel: ViewModelProduct = viewModel()
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        backgroundColor = MaterialTheme.colors.secondary,
        topBar = {
            TopAppBar(
                title = {
                    Text("Add your product")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                },
                actions = {
                    IconButton(onClick = {/* Do Something*/ }) {
                        Icon(Icons.Filled.Share, null)
                    }
                    IconButton(onClick = {/* Do Something*/ }) {
                        Icon(Icons.Filled.Settings, null)
                    }
                },
                backgroundColor = MaterialTheme.colors.secondaryVariant)  },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {showDialog = true},
                modifier = Modifier.padding(bottom = 50.dp),
                backgroundColor = MaterialTheme.colors.secondaryVariant
            )
            {
                Icon(Icons.Filled.Add, contentDescription = "")
            }
        },
        content = {
            if (showDialog){
                addBookDialog(context, dismissDialog = {showDialog = false}, {viewModel.add(it)})
            }
            LazyColumn(
                contentPadding = PaddingValues(
                    vertical = 8.dp,
                    horizontal = 8.dp
                )
            )
            {
                items(viewModel.productList, key={product -> product.id}) { book ->
                    ProductItem(item = book, context, {viewModel.delete(it)})
                }
            }
        }
    )
}

@Composable
fun addBookDialog(context: Context, dismissDialog:() -> Unit, addProduct: (product) -> Unit){
    var TaskTextField by remember {
        mutableStateOf("")
    }

    AlertDialog(
        onDismissRequest = { dismissDialog},
        title={ Text(text = stringResource(id = R.string.addproduct), style = MaterialTheme.typography.h6) },
        text = {
            Column(modifier = Modifier.padding(top=20.dp)) {
                TextField(label = { Text(text= "ProductName") }, value = TaskTextField, onValueChange = {TaskTextField=it})
            }
        },
        confirmButton = {
            Button(onClick = {
                if(TaskTextField.isNotEmpty()) {
                    val newID = UUID.randomUUID().toString();
                    addProduct(product(newID, TaskTextField))
                    Toast.makeText(
                        context,
                        context.resources.getString(R.string.addedproduct),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                dismissDialog()
            })
            {
                Text(text = stringResource(id = R.string.add))
            }
        },dismissButton = {
            Button(onClick = {
                dismissDialog()
            }) {
                Text(text = stringResource(id = R.string.cancel))
            }
        }
    )
}

@Composable
fun deleteProductDialog(context: Context, dismissDialog:() -> Unit, item:product, deleteBook: (product) -> Unit){
    AlertDialog(
        onDismissRequest = { dismissDialog},
        title={ Text(text = stringResource(id = R.string.delete), style = MaterialTheme.typography.h6) },
        confirmButton = {
            Button(onClick = {
                deleteBook(item)
                Toast.makeText(
                    context,
                    context.resources.getString(R.string.deleteproduct),
                    Toast.LENGTH_SHORT
                ).show()
                dismissDialog()
            })
            {
                Text(text = stringResource(id = R.string.yes))
            }
        },dismissButton = {
            Button(onClick = {
                dismissDialog()
            }) {
                Text(text = stringResource(id = R.string.no))
            }
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductItem(item: product, context: Context, deleteProduct: (product) -> Unit) {
    var showDeleteDialog by remember { mutableStateOf(false) }

    Card(
        elevation = 6.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.White,
        contentColor = MaterialTheme.colors.onPrimary,
        border = BorderStroke(2.dp, color = MaterialTheme.colors.secondary),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .combinedClickable(
                onClick = {
                    Toast
                        .makeText(
                            context,
                            context.resources.getString(R.string.readmsg) + " " + item.prod,
                            Toast.LENGTH_SHORT
                        )
                        .show()
                },
                onLongClick = { showDeleteDialog = true }
            )
    ) {
        Row()
        {

            Column(modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp)
                .padding(start = 10.dp)) {
                Text(text = item.prod, style = MaterialTheme.typography.h6)
                //Spacer(modifier = Modifier.width(150.dp))
            }
            //Spacer(modifier = Modifier.width(10.dp))
        }
    }
    if (showDeleteDialog){
        deleteProductDialog(context, dismissDialog = {showDeleteDialog = false}, item, deleteProduct)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MangroveTheme {
        ProductScreen()
    }
}