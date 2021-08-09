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
      axios.get('/api/employees')
      .then(function (response){
        alert(response.data)
      })
      .catch(function (error) {
        alert(error)
      })
    }
  }
}
</script>

<style scoped>

</style>