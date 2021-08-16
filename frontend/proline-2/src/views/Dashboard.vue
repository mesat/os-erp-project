<template>
  <CCard align="left" >
    <CCardHeader >
      <CCardBody>

        <CRow>

          <CCol col="6">
            <CJumbotron class="h-75">
            <CCardText id="header">
          <h1>PROLİNE BİLİŞİM</h1>

            </CCardText>
            </CJumbotron>
          </CCol>


              <CCol col="6">
                <CJumbotron class="h-75">
                <CCardText >
                  <h1 id="contactInformation">Contact Information</h1>

                  Şerifali Mah. Beyan Sok. No:60/1 34775 Ümraniye - ISTANBUL<br>
                  Tel  : +90 (216) 528 62 00<br>
                  Faks: +90 (216) 528 63 00
                </CCardText>
                 </CJumbotron>
              </CCol>

        </CRow>


        <CRow>

          <CCol col="6">
            <CJumbotron class="h-auto">
              <CCardText >
                <p1>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                  Vestibulum accumsan condimentum enim a varius.
                  Maecenas placerat mattis risus, quis elementum augue aliquet vel.
                  Pellentesque id metus magna. Praesent iaculis diam quis odio dapibus,
                  in elementum nulla ornare. Phasellus posuere eros nisi, in porta purus fermentum vitae.
                  Quisque eu sem est. Nulla gravida tortor convallis posuere condimentum.
                  Aliquam pulvinar ullamcorper gravida. Nullam sed erat dolor. Nunc finibus,
                  elit dignissim fringilla lobortis, neque metus hendrerit urna,
                  id aliquam ligula mauris id nunc.
                </p1>
              </CCardText>
            </CJumbotron>
          </CCol>


          <CCol col="6">
            <CJumbotron class="h-auto">
              <CCardText>
                <p2>Maecenas semper efficitur tellus eget placerat.
                  Nullam accumsan, justo nec feugiat pellentesque,
                  ante dui pulvinar turpis, eu blandit velit augue ac risus. Nulla nec accumsan mauris,
                  a malesuada eros. Curabitur neque odio, bibendum eu velit eu, luctus laoreet augue.
                  Curabitur neque ligula, iaculis quis sem quis, vulputate pretium enim.
                  Fusce consequat scelerisque dictum. Morbi tristique blandit facilisis.
                  Quisque eu massa porttitor ex posuere finibus.
                  Nam rhoncus, augue fermentum porta molestie, nulla nisl dignissim arcu,
                  eu semper ante ipsum et purus. Aliquam aliquam odio eu finibus feugiat.</p2>
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
}

  #contactInformation{
    color: #2c3e50;
    text-shadow: 2px 2px #3c4b64;
    font-size: xx-large;
    font-family: "Segoe UI Black";

  }


</style>