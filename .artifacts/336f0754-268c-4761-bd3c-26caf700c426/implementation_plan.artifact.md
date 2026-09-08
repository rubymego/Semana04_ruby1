# Implementation Plan - ConsultaProductosREST

This plan outlines the steps to develop the Android application that fetches and displays product information from a REST API using Retrofit.

## User Review Required

> [!IMPORTANT]
> I will use `https://fakestoreapi.com/` as the base URL for the REST service. If you have a different API endpoint, please provide it so I can adjust the models and the client configuration.

## Proposed Changes

### Configuration

#### [MODIFY] [libs.versions.toml](file:///C:/Users/Usuario/Documents/PRACTICAS_CALIFICADAS/ConsultaProductosREST/gradle/libs.versions.toml)
Add versions and libraries for Retrofit, Gson, and OkHttp.

#### [MODIFY] [build.gradle.kts](file:///C:/Users/Usuario/Documents/PRACTICAS_CALIFICADAS/ConsultaProductosREST/app/build.gradle.kts)
Include the new dependencies in the app module.

#### [MODIFY] [AndroidManifest.xml](file:///C:/Users/Usuario/Documents/PRACTICAS_CALIFICADAS/ConsultaProductosREST/app/src/main/AndroidManifest.xml)
Add the `<uses-permission android:name="android.permission.INTERNET" />`.

---

### Data Models

#### [NEW] [Producto.java](file:///C:/Users/Usuario/Documents/PRACTICAS_CALIFICADAS/ConsultaProductosREST/app/src/main/java/com/example/consulta_productos_rest/Producto.java)
POJO to represent a product (ID, Name, Price, Category).

#### [NEW] [ProductoResponse.java](file:///C:/Users/Usuario/Documents/PRACTICAS_CALIFICADAS/ConsultaProductosREST/app/src/main/java/com/example/consulta_productos_rest/ProductoResponse.java)
If the API wraps the list in an object. (For Fakestore, it's a direct list, but I'll provide it if needed).

---

### Networking

#### [NEW] [RetrofitClient.java](file:///C:/Users/Usuario/Documents/PRACTICAS_CALIFICADAS/ConsultaProductosREST/app/src/main/java/com/example/consulta_productos_rest/RetrofitClient.java)
Singleton to provide the Retrofit instance.

#### [NEW] [ApiService.java](file:///C:/Users/Usuario/Documents/PRACTICAS_CALIFICADAS/ConsultaProductosREST/app/src/main/java/com/example/consulta_productos_rest/ApiService.java)
Interface defining the API endpoints using Retrofit annotations.

---

### UI Components

#### [MODIFY] [activity_main.xml](file:///C:/Users/Usuario/Documents/PRACTICAS_CALIFICADAS/ConsultaProductosREST/app/src/main/res/layout/activity_main.xml)
Add a `RecyclerView` to display the list of products.

#### [NEW] [item_producto.xml](file:///C:/Users/Usuario/Documents/PRACTICAS_CALIFICADAS/ConsultaProductosREST/app/src/main/res/layout/item_producto.xml)
Layout for a single product row.

#### [NEW] [ProductoAdapter.java](file:///C:/Users/Usuario/Documents/PRACTICAS_CALIFICADAS/ConsultaProductosREST/app/src/main/java/com/example/consulta_productos_rest/ProductoAdapter.java)
Adapter to bind product data to the `RecyclerView`.

#### [MODIFY] [MainActivity.java](file:///C:/Users/Usuario/Documents/PRACTICAS_CALIFICADAS/ConsultaProductosREST/app/src/main/java/com/example/consulta_productos_rest/MainActivity.java)
Implement the API call and setup the RecyclerView.

---

## Verification Plan

### Automated Tests
- N/A for this initial implementation, but I will ensure the build is successful.

### Manual Verification
1.  Deploy the app to the device.
2.  Verify that the list of products is fetched and displayed.
3.  Check that ID, Name, Price, and Category are correctly shown.
