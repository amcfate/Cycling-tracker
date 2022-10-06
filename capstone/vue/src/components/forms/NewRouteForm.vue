<template>

       <form id="route-form">
        
      <div class="container">
        <label class="form-el" for="activityName">Activity Name:</label>
        <input
          class="form-el"
          type="text"
          name="activityName"
          id=""
          v-model="a"
        />
        <label class="form-el" for="activityDate">Date:</label>
        <input class="form-el" type="date" v-model="a" />
        <label class="form-el" for="description">Description:</label>
        <textarea
          class="form-el"
          type="text"
          name="description"
          v-model="a"
        />
      </div>
      <div class="container">
        <button class="add-btn form-el" @click="submitForm()">
          Add Activity
        </button>
      </div>
  </form>
</template>

<script>
export default {};
</script>

<style>


#route-form {
  display: flex;
  flex-direction: row;
  justify-content: center;
  width: auto;
  flex-wrap: wrap;
  background-color: #9BCEA8;
  border-radius: 8px;
}

.container {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
   margin-top: 20px;
   margin-left: 10%; 
   margin-right: 10%;
   width: 100%;
}
.add-btn {
  
  
  width: 100%;

}
.form-el {
  
  width: 100%;
 
}
</style>