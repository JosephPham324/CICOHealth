let nav_links = document.querySelectorAll(".nav-link");
let contents = document.querySelectorAll(".info>div");
let form_container = document.querySelector(".form");
let form = document.querySelector(".form form");
let overlay = document.querySelector(".form .overlay");
let password_value = document.querySelector("#password-value").textContent;
let password_span = document.querySelector("#password-value");
let toggle_password = document.querySelector("#toggle-password-visibility");
let eye_open = '<i class="fa fa-eye" aria-hidden="true"></i>';
let eye_close = '<i class="fa fa-eye-slash" aria-hidden="true"></i>';
hideTextContent(password_span, "*");

toggle_password.addEventListener("click", () => {
  if (password_span.classList.contains("hidden")) {
    password_span.classList.remove("hidden");
    password_span.classList.add("visible");
    toggle_password.innerHTML = eye_open;
    showTextContent(password_span, password_value);
  } else {
    password_span.classList.remove("visible");
    password_span.classList.add("hidden");
    toggle_password.innerHTML = eye_close;
    hideTextContent(password_span, "*");
  }
});

nav_links.forEach((item) => {
  item.addEventListener("click", () => {
    let destination = document.querySelector(
      `${item.getAttribute("data-destination")}`
    );
    contents.forEach((item) => item.classList.remove("active"));
    nav_links.forEach((item) => item.classList.remove("active"));
    destination.classList.add("active");
    item.classList.add("active");
  });
});

let edit_buttons = document.querySelectorAll(".edit");

edit_buttons.forEach((button) => {
  button.addEventListener("click", () => {
    form_container.classList.add("active");
  });
});

overlay.addEventListener("click", () => {
  form_container.classList.remove("active");
});

function hideTextContent(element, replaceCharacter) {
  element.textContent = element.textContent.replace(/./g, replaceCharacter);
}
function showTextContent(element, content) {
  element.textContent = content;
}

let loginEditButtons = document.querySelectorAll(".login-info .edit");
let userEditButtons = document.querySelectorAll(".user-info .edit");
let healthEditButtons = document.querySelectorAll(".health-info .edit");

loginEditButtons.forEach((button) => {
  button.addEventListener('click',()=>{
    let field = button.parentElement.childNodes[3];
    let loginFields = document.querySelectorAll('.login-info .field-value')
    let formContent = `
    <div class="form-group row" style = "display:${loginFields[0]===field?'flex':'none'}">
      <label for="username" class="col-4 col-form-label">Username</label>
      <div class="col-8">
        <input
          id="username"
          name="username"
          placeholder="Your username"
          type="text"
          class="form-control"
          aria-describedby="usernameHelpBlock"
          value = "${loginFields[0].textContent}"
        />
        <span id="usernameHelpBlock" class="form-text text-muted"
          >Help text</span
        >
      </div>
    </div>
    <div class="form-group row" style = "display:${loginFields[1]===field?'flex':'none'}">
      <label for="password" class="col-4 col-form-label">Password</label>
      <div class="col-8">
        <input
          id="password"
          name="password"
          placeholder="Your password"
          type="text"
          class="form-control"
          aria-describedby="passwordHelpBlock"
          value = "${password_value}"
        />
        <span id="passwordHelpBlock" class="form-text text-muted"
          >Help text</span
        >
      </div>
    </div>
    <div class="form-group row">
      <div class="offset-4 col-8">
        <button name="submit" type="submit" class="btn btn-primary">
          Submit
        </button>
      </div>
    </div>`;
    form.innerHTML = formContent;
  })
  

});
