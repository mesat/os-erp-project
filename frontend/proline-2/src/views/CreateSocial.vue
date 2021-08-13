<template>
  <CCard>
    <CCardHeader>
      <h1>
        Create Social Media
      </h1>
    </CCardHeader>
    <CCardBody>
      <div id="selectedContainer">
        <CIcon :name="selected" id="selectedIcon" size="custom"/>
      </div>

      <div id="iconContainer">
        <CButton class="iconButton" v-for="item in iconNames" :key="item" @click="clickIcon(item)" >
          <CIcon :name="item" customClasses="icons" size="custom"/>
        </CButton>
      </div>

      <CRow alignHorizontal="end" >
        <CCol col="auto"  >
          <CButton color="success" v-on:click="submit"> Submit
          </CButton>
        </CCol>
      </CRow>
    </CCardBody>
  </CCard>
</template>

<script>

import {iconsSet} from "../assets/icons/icons";
import * as regex from "@/javascript/_regex";

export default {
  name: "CreateSocial",
  data() {
    return {
      selected: ''
    }
  },

  mounted() {
    console.log(Object.keys(iconsSet))
  },
  computed: {
    iconNames() {
      return Object.keys(iconsSet)
    }
  },
  methods: {
    clickIcon(item) {
      this.selected = item
    }
  }
}
</script>

<style scoped lang="scss">
#iconContainer {
  background: #ddd;
  display: flex;
  flex-wrap: wrap;
  padding: 10px;
  border-radius: 10px;
  margin-bottom:10px;
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
  .selectedIcon {

  }
}
</style>