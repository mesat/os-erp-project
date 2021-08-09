<template>
  <div>
    <CButton color="success" @click="click">
      test request
    </CButton>
  </div>
</template>

<script>
const axios = require('axios');

export default {
  name: "VueTest",
  data ()  {
    return {

    }
  },
  computed: {

  },
  methods: {
    click(){
      axios.get('https://os-erp.herokuapp.com/employees')
      .then(function (response){
        alert('a')
        alert(response)
      })
    }
  }
}
</script>

<style scoped>

</style>