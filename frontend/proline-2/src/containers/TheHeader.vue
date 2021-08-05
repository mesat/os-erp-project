<template>
  <CHeader fixed with-subheader light>
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
  </CHeader>
</template>

<script>
export default {
  name: "TheHeader"
}
</script>

<style scoped>

</style>