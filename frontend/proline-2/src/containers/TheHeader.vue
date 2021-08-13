<template>
  <CHeader fixed with-subheader light id="headerMine">
    <CToggler
        in-header
        class="ml-3 d-lg-none"
        @click="$emit('toggle')"
    />
    <CToggler
        in-header
        class="ml-3 d-md-down-none"
        @click="$emit('toggle')"
    />
    <CBreadcrumbRouter id="breadcrumbRouter"/>
  </CHeader>
</template>

<script>
export default {
  name: "TheHeader"
}

</script>

<style scoped>
.breadcrumb {
  margin-bottom: auto;
  margin-top: auto;

  border: none;
}


</style>