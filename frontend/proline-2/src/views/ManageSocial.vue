<template>
  <CCard>
    <CCardHeader>
      <h1>
        Manage Social Media
      </h1>
    </CCardHeader>
    <CCardHeader>
      <CRow>
        <CCol col="1">
          <CToggler inHeader @click="toggleNew">
            <CIcon name="cilList"/>
          </CToggler>
        </CCol>
        <CCol col="11">
          <h4>
            <CCardText>
              Create New +
            </CCardText>
          </h4>
        </CCol>
      </CRow>
    </CCardHeader>
    <CCollapse :show="showNew">

      <CCardBody>
        <CRow>
          <CCol>
            <CInput
                name="name"
                label="Name"
                placeholder="Enter name"
            />
          </CCol>
        </CRow>
        <CRow>
          <div id="selectedContainer">
            <CIcon :name="selected" id="selectedIcon" size="custom"/>
          </div>
        </CRow>
        <CRow>
          <div id="iconContainer">
            <CButton class="iconButton" v-for="item in iconNames" :key="item" @click="clickIcon(item)">
              <CIcon :name="item" customClasses="icons" size="custom"/>
            </CButton>
          </div>
        </CRow>
        <CRow alignHorizontal="end">
          <CCol col="auto">
            <CButton color="success" v-on:click="submit"> Submit
            </CButton>
          </CCol>
        </CRow>
      </CCardBody>
    </CCollapse>
    <CCardBody>
      <CDataTable :fields="fields" :items="items">
        <template #icon="{item}">
          <td>
            <CIcon :name="item.icon"/>
          </td>
        </template>
        <template #delete="{item}">
          <td>
            <CButton color="danger" @click="delete_item(item['name'])" size="sm">-</CButton>
          </td>
        </template>
      </CDataTable>
    </CCardBody>
  </CCard>
</template>

<script>

import {iconsSet} from "../assets/icons/icons";
import {axios} from "../javascript/_axios";

const fields = [{
  key: "icon",
  label: "Icon",
  _classes: "col-2"
}, {
  key: "name",
  label: "Name",
  _classes: "col-10"
}, {
  key: "delete",
  label: '',
  _classes: "col-0"
}]

export default {
  name: "CreateSocial",
  data() {
    return {
      selected: '',
      showNew: false,
      fields: fields,
      items: []
    }
  },
  mounted() {
    this.update()
  },

  computed: {
    iconNames() {
      return Object.keys(iconsSet)
    }
  },
  methods: {
    clickIcon(item) {
      this.selected = item
    },
    toggleNew() {
      this.showNew = !this.showNew
    },
    update() {
      axios.get("/socialmedia").then((response) => {
        this.items = response.data
            .filter(function (a) {
              return a["platform"]!=='MAIL' && a["platform"]!=='TEL_NO'
            })
            .map(function (a) {
              return {
                "icon": a["icon"],
                "name": a["platform"]
              }
            })
      })
      .catch((a) => { alert(a) })
    },
    delete_item() {
      //axios.delete("/socialmedia",)
    },
    submit() {

    }
  }
}
</script>

<style scoped lang="scss">
#iconContainer {
  margin-left: 15px;
  background: #ddd;
  display: flex;
  flex-wrap: wrap;
  padding: 10px;
  border-radius: 10px;
  margin-bottom: 10px;
  margin-right: 40px;
  width: 96%;

  .iconButton {
    flex: 0 0 40px;
    margin: 5px;
    padding: 0px;
  }
}


#selectedContainer {
  background: #aaa;
  border-radius: 10px;
  width: 50px;
  height: 50px;
  margin-bottom: 10px;
  padding: 5px;
  margin-left: 15px;


  .selectedIcon {

  }
}
</style>