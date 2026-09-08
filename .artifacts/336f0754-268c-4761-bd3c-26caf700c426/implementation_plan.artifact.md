# Implementation Plan - Add Product Feature

This plan adds functionality to create new products directly within the `MainActivity` screen.

## Proposed Changes

### UI Update

#### [MODIFY] [activity_main.xml](file:///C:/Users/Usuario/Documents/PRACTICAS_CALIFICADAS/ConsultaProductosREST/app/src/main/res/layout/activity_main.xml)
- Add a form at the top of the screen (inside a `MaterialCardView`) containing:
    - `EditText` for Product Name.
    - `EditText` for Price (numeric input).
    - `EditText` for Category.
    - `Button` to "Add Product".
- Reposition the `RecyclerView` to sit below this new form.

---

### Networking layer

#### [MODIFY] [ApiService.java](file:///C:/Users/Usuario/Documents/PRACTICAS_CALIFICADAS/ConsultaProductosREST/app/src/main/java/com/example/consulta_productos_rest/ApiService.java)
- Add a new `@POST("products")` method to send product data to the server.

---

### Logic Update

#### [MODIFY] [ProductoAdapter.java](file:///C:/Users/Usuario/Documents/PRACTICAS_CALIFICADAS/ConsultaProductosREST/app/src/main/java/com/example/consulta_productos_rest/ProductoAdapter.java)
- Add a method to add a new product to the existing list and notify the adapter.

#### [MODIFY] [MainActivity.java](file:///C:/Users/Usuario/Documents/PRACTICAS_CALIFICADAS/ConsultaProductosREST/app/src/main/java/com/example/consulta_productos_rest/MainActivity.java)
- Initialize the new form fields.
- Implement the click listener for the "Add" button:
    - Validate inputs.
    - Create a `Producto` object.
    - Perform the Retrofit `POST` request.
    - On success, add the new product to the list and clear the fields.

---

## Verification Plan

### Manual Verification
1.  Open the app.
2.  Enter values in Name, Price, and Category.
3.  Click "Add Product".
4.  Verify that a Toast message indicates success and the new product appears at the top/bottom of the list.
5.  Check that the input fields are cleared after adding.
