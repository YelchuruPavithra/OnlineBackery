import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth/auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  hidePassword = true;
  signupForm!: FormGroup;
  passwordMatchValidator: any;

  constructor( private fb: FormBuilder,
    private snackBar: MatSnackBar,
    private authService: AuthService,
    private router: Router)
    {

    }

    ngOnInit(): void{
      this.signupForm = this.fb.group({
        name: [null,[Validators.required]],
        email: [null,[Validators.required,Validators.email]],
        password: [null,[Validators.required]],
        confirmPassword: [null, [Validators.required]],
      });
    }

    togglePasswordVisibility()
    {
      this.hidePassword = !this.hidePassword
    }

onSubmit():void {
  const password = this.signupForm.get('password')?.value;
  const confirmPassword = this.signupForm.get('confirmpassword')?.value;

  if(password ! == confirmPassword)
  {
      this.snackBar.open('Passwords do not match.','close',{ duration: 5000, panelClass:'error-snackbar'});
      return;
  }

  this.authService.register(this.signupForm.value).subscribe(
    (response) =>{
      this.snackBar.open('sign up successful!', 'close',{duration: 5000});
      this.router.navigateByUrl('/login');
    },
    (error) =>{
      this.snackBar.open('sign up failed. please try again.','close',{duration: 5000, panelClass:'error-snackbar'});
    }
  )
}
}





