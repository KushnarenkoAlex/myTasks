//checks form on log_in.html
function validate(form) {
      var login=$('#login').val();
      if(!login)
      {
          $('#loginError').html(" LOGIN IS EMPTY");
      }
      else{
      $('#loginError').html("");
      }
      var password=$('#password').val();
      if(!password)
      {
          $('#passwordError').html(" PASSWORD IS EMPTY");
      }else{
      $('#passwordError').html("");}
}