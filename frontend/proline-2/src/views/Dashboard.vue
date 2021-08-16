<template>
  <CCard align="left" >
    <CCardHeader >
      <CCardBody>

        <CRow>

          <CCol col="3" >
            <CJumbotron class="h-75">
            <CCardText id="header" >
          <h1>OS-ERP PROJECT</h1>

            </CCardText>
            </CJumbotron>
          </CCol>


              <CCol col="9">
                <CJumbotron class="h-75">
                <CCardText >
                  <h1>Contact Information</h1>

                  Şerifali Mah. Beyan Sok. No:60/1 34775 Ümraniye - ISTANBUL<br>
                  Tel  : +90 (216) 528 62 00<br>
                  Faks: +90 (216) 528 63 00
                </CCardText>
                 </CJumbotron>
              </CCol>

        </CRow>


        <CRow>

          <CCol col="9">
            <CJumbotron class="h-a" >
              <CCardText >
                <h1>Information</h1>
                <p1>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ac interdum velit. Duis ac felis bibendum, dignissim orci sit amet, sodales tellus. Proin et mi ut justo sollicitudin semper. Mauris sit amet condimentum libero, a finibus orci. Donec scelerisque suscipit augue, sit amet volutpat neque scelerisque ut. Aenean ullamcorper vulputate dui, et condimentum elit auctor eget. Fusce nec ullamcorper lorem. Nullam auctor ex vitae cursus vestibulum. Integer pretium rutrum laoreet. Duis pellentesque libero odio, vitae viverra libero tempor at. Ut ut purus et neque sollicitudin semper nec ac nibh. Nulla vitae maximus enim. Maecenas imperdiet urna ac enim sollicitudin, non porttitor enim dictum. Nam tincidunt felis et sapien faucibus porttitor. Praesent eleifend dui eros. Praesent facilisis erat elit, id tincidunt orci lacinia vel.

                  Nulla id neque id magna vulputate eleifend. Maecenas sapien justo, placerat sed facilisis vitae, placerat ut nulla. Nunc eget faucibus neque. Phasellus vulputate sed diam vitae sodales. Vestibulum pellentesque nunc et iaculis iaculis. Aenean a nisl nec lacus laoreet dapibus ac efficitur dolor. Nullam sit amet odio varius, suscipit elit at, malesuada tortor. Curabitur euismod dapibus libero, ut aliquet nibh aliquam non. Morbi venenatis eu sem nec vestibulum. Morbi consectetur quam quis est fringilla dictum condimentum a massa. Suspendisse potenti. Curabitur venenatis efficitur est, eu venenatis metus accumsan nec. Suspendisse interdum massa purus, at interdum purus elementum at. Donec blandit vitae purus vel luctus. Aenean suscipit enim nisl, ut ornare ex laoreet eget.
                </p1>
              </CCardText>
            </CJumbotron>
          </CCol>


          <CCol col="3">
            <CJumbotron class="h-75" >
              <CCardText id="dynamic" >
                <h1>NUMBER OF EMPLOYEES:</h1>
                <h2 id="number">250</h2>
                <p2></p2>
              </CCardText>
            </CJumbotron>
          </CCol>

        </CRow>

      </CCardBody>

    </CCardHeader>
  </CCard>
</template>

<script>
export default {
  name: "Dashboard"
}
</script>

<style scoped>
#header {
  color: #42b983;
  text-shadow: 3px 3px #3c4b64;
  font-size: larger;
  font-family: "Segoe UI Black";
  position: absolute;
}
#dynamic {
  position: absolute;
}

#number{
  color: #42b983;


}




</style>