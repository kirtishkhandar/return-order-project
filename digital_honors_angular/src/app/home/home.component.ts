import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RequestService } from '../_services/request.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  content?: string;
  process: string = 'request';
  process_status: string = 'Create a return request';
  status_percent = 10;
  isLoggedIn = false;

  form: any = {
    name: null,
    number: null ,
    comp_type: null,
    comp_name: null,
    quantity: null
  };

  requestId: string = '';
  processingCharge: string = '';
  pakadgingAndDeliveryCharge: string = '';
  dateOfDelivery: string = '';
  gotdetails= false;
  requestFailed= false;
  errorMessage = '';
  paymentDone = false;


  constructor(private tokenStorageService: TokenStorageService,
    private requestService: RequestService, private router: Router,
     private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    if(!this.isLoggedIn){
      setTimeout(() => {
        this.router.navigate(['login'])
      }
      ,1000);
    }
  }  

  onSubmit(): void {
    const { name, number, comp_type, comp_name, quantity } = this.form;

    this.requestService.getDetails(name, number, comp_type, comp_name, quantity).subscribe({
      next:response=>{
        this.requestId = response.requestId;
        this.processingCharge = response.processingCharge;
        this.pakadgingAndDeliveryCharge = response.pakadgingAndDeliveryCharge;
        this.dateOfDelivery = response.dateOfDelivery;
        this.gotdetails = true;
        this.status_percent = 50;
        this.process_status = 'Request Charges'
        this.process = 'charges';
      },
      error: err => {
        this.errorMessage = err.error.message;
        this.requestFailed = true;
        if(this.errorMessage.includes("[401]")){
          this.isLoggedIn = false;
        }
      }
    })
  }

  onPayment():void{
    this.router.navigate(['payment'], {relativeTo:this.route});
    this.process_status = 'complete the payment';
    this.status_percent = 80;
    this.process = 'payment';
  }

  paymentStatus(paymentDone: any):void{
    console.log("event emmitted@@@@@:",paymentDone);
    this.paymentDone = paymentDone;
    if(this.paymentDone == true){
      this.status_percent = 100;
      this.process_status = 'Order Placed';
    }
    
  }
}
