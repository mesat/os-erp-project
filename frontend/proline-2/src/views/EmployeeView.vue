<template>
  <CCard align="left">
    <CCardHeader id="header">
      <img src="../assets/icons/admin.jpg" height="100" width="100" alt="img"/>
      <span id="name">
            {{ item.name }}
          </span>
      <span id="surName">
            {{ item.surName }}
          </span>
    </CCardHeader>
    <CCardBody id="body">
      <CSpinner color="gray-600" v-if="loading" grow style="margin: 100px;"/>
      <div v-else>
        <CRow>
          <CCol col="4">
            <CCardText id="date">
              <CRow><span id="role"> {{ item.role }}</span></CROW>
              <CRow><strong>Start Date {{ item.date }}</strong></CRow>
            </CCardText>
          </CCol>
          <CCol col="8">
            <CCardText id="bio">
              <h1 id="blok">Biography</h1>
              <CRow><strong> {{ item.bio }} </strong></CROW>
            </CCardText>
            <CRow><span id="telephone">Telephone:<strong> {{ telephone }} </strong></span></CRow>
            <CRow><span id="mail">Mail:<strong> {{ mail }}  </strong></span></CRow>
            <CRow>
              <CDataTable :fields="fields" :items="socials">
                <template #icon="{item}">
                  <td>
                    <CIcon :name="item.icon"/>
                  </td>
                </template>
              </CDataTable>
            </CRow>
          </CCol>
        </CRow>
      </div>
    </CCardBody>
  </CCard>
</template>


<script>
import {axios} from "../javascript/_axios"
import Employee from "../javascript/_employee"


const fields = [{
  key: "icon",
  label: "",
  _classes: "col-xs-1"
}, {
  key: "name",
  label: "Name",
  _classes: "col-sm-2"
}, {
  key: "nick",
  label: "Nick",
  _classes: "col-sm-2"
}, {
  key: "link",
  label: "Link",
  _classes: "col-xl-7"
}]

export default {
  name: "EmployeeView",
  props: ['itemx'],
  data() {
    return {
      fields: fields,

      item: {},
      loading: false
    }
  },
  mounted() {
    this.loading = true
    axios.get('/employees/' + this.$route.params.id)
        .then((response) => {
          //this.item = new Employee(x['name'], x['surname'], '11/11/1111', x['rol'], x['bio']).setId(x['id'])
          this.item = new Employee().parse(response.data)
          this.loading = false
        })
        .catch(function (error) {
          alert(error)
        })
  },
  computed: {
    socials () {
      return this.item.socials.filter(function (a) {
        return a.name!=='MAIL' && a.name!=='TEL_NO'
      })
    },
    mail () {
      return this.item.socials.find((a) =>{ return a.name==='MAIL'}).link
    },
    telephone () {
      return this.item.socials.find((a) =>{ return a.name==='TEL_NO'}).link
    }
  }



}
</script>

<style scoped lang="scss">
$secondary-50: #9da5b1;
$secondary: #3c4b64;

#name {
  color: rgb(255, 255, 255);
  font-size: 45px;
}

#surName {
  color: rgb(255, 255, 255);
  font-size: 45px;
}

#role {
  font-family: "Berlin Sans FB";
  color: rgb(60, 60, 60);
  font-size: 35px;

}

#date {
  color: rgb(60, 60, 60);
  font-size: 15px;
  margin-top: 5px;
}

#bio {
  border-style: solid;
  box-sizing: content-box;
  padding: 10px;
  height: 400px;

  color: rgb(60, 60, 60);
  border-radius: 8px;
  border-width: medium;
  border-color: #3c4b64;;
  background-color: #b1b7c1;
  margin-bottom: 20px;
  overflow: auto;


}

#telephone {
  box-sizing: content-box;
  height: 20px;
  color: rgb(60, 60, 60);
  font-size: 16px;
  margin-bottom: 10px;
}

#mail {
  box-sizing: content-box;
  height: 20px;
  color: rgb(60, 60, 60);
  font-size: 16px;
  margin-bottom: 15px;

}

#header {
  background-color: #3c4b64;

}

#body {
  background-color: #b1b7c1;
  display: block;
}

#blok {
  border-style: solid;
  border-radius: 20px;
  border-width: medium;
  border-color: rgba(150, 150, 150, 0.6);
  text-align: center;
  font-family: "Arial Rounded MT Bold";

}


</style>