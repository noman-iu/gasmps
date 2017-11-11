<!-- CSS to style the file input field as button and adjust the Bootstrap progress bars -->
<link rel="stylesheet" href="file-upload/css/jquery.fileupload.css">
<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
<script src="file-upload/js/jquery.ui.widget.js"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="file-upload/js/jquery.iframe-transport.js"></script>
<script src="file-upload/js/main.js"></script>
<!-- The basic File Upload plugin -->
<script src="file-upload/js/jquery.fileupload.js"></script>
<div class="container-fluid">
   <!-- The fileinput-button span is used to style the file input field as button -->
   <span class="btn btn-success fileinput-button">
      <i class="glyphicon glyphicon-plus"></i>
      <span>Select files...</span>
      <!-- The file input field used as target for the file upload widget -->
      <input id="fileupload" type="file" name="files[]" multiple>
   </span>
   <br>
   <!-- The global progress bar -->
   <div id="progress" class="progress">
      <div class="progress-bar progress-bar-success"></div>
   </div>
   <!-- The container for the uploaded files -->
   <div id="files" class="files"></div>
   <br>
   <div class="row">
      <div class="col-md-12">
         <div class="card">
            <div class="card-header" data-background-color="purple">
               <h4 class="title">Upload summary</h4>
               <p class="category">Here is a summary for this table</p>
            </div>
            <div class="card-content table-responsive">
               <table class="table">
                  <thead class="text-primary">
                     <th>File Name</th>
                     <th>File Size(Kb)</th>
                     <th>Status</th>
                  </thead>
                  <tbody>
                     <tr>
                        <td>Dakota Rice</td>
                        <td class="text-primary">$36,738</td>
                        <td>Oud-Turnhout</td>
                     </tr>
                     <tr>
                        <td>Minerva Hooper</td>
                        <td class="text-primary">$23,789</td>
                        <td>Sinaai-Waas</td>
                     </tr>
                     <tr>
                        <td>Sage Rodriguez</td>
                        <td class="text-primary">$56,142</td>
                        <td>Baileux</td>
                     </tr>
                     <tr>
                        <td>Dakota Rice</td>
                        <td class="text-primary">$36,738</td>
                        <td>Oud-Turnhout</td>
                     </tr>
                     <tr>
                        <td>Minerva Hooper</td>
                        <td class="text-primary">$23,789</td>
                        <td>Sinaai-Waas</td>
                     </tr>
                     <tr>
                        <td>Sage Rodriguez</td>
                        <td class="text-primary">$56,142</td>
                        <td>Baileux</td>
                     </tr>
                  </tbody>
               </table>
               
            </div>
         </div>
      </div>
   </div>
</div>